const API_url = "http://localhost:8080/api/v1/todos"
let todos =[]
//Thêm công việc
function getTodosAPI(status) {
    switch (status) {
        case "all": {
            return axios.get(`${API_url}`)
        }
        case "unactive": {
            return axios.get(`${API_url}?status=false`)
        }
        case "active": {
            return axios.get(`${API_url}?status=true`)
        }
        default: {
            return axios.get(`${API_url}`)
        }
    }
}

//Truy cập vào các thành phần
const todoListEle = document.querySelector(".todo-list")
function renderTodos(arr) {
    todoListEle.innerHTML = ""

    if (arr.length == 0) {
        todoListEle.innerHTML = "None"
        return;
    }

    let html = ""
    for (let i = 0; i < arr.length; i++) {
        const t = arr[i]
        html += `
            <div class="todo-item ${t.status ? "active-todo":""}">
                <div class="todo-item-title">
                    <input type="checkbox" 
                    ${t.status ? "checked":""} 
                    onclick="toggleStatus(${t.id})" />
                    <p>${t.title}</p>
                </div>
                <div class="option">
                    <button class="btn btn-update">
                        <img src="./img/pencil.svg" alt="icon" />
                    </button>
                    <button class="btn btn-delete" onclick="deleteTodo(${t.id})">
                        <img src="./img/remove.svg" alt="icon" />
                    </button>
                </div>
            </div>
        `
    }
    todoListEle.innerHTML = html;
}
//Lấy ra công việc
async function getTodos(status) {
    try {
        let res = await getTodosAPI(status)
        todos=res.data
        renderTodos(res.data)
    } catch (error) {
        console.log(error)
    }
}
getTodos()

//Xóa công việc
async function deleteTodo(id){
    try {
        //Gọi API xóa
        await axios.delete(`${API_url}/${id}`)
        todos.forEach((todo,index) => {
            if(todo.id==id){
                todos.splice(index,1)
            }
        });
        //Sau khi xóa thì render lại giao diênk
        renderTodos(todos)
        
    } catch (error) {
        console.log(error)
    }
}

//
const inputTodoEle = document.getElementById("todo-input")
const btnAdd = document.getElementById("btn-add")
btnAdd.addEventListener("click",async function(){
    try {
        let title = inputTodoEle.value;
        if(title==""){
            alert("Không được để trống tiêu đề")
            return
        }

        let res = await axios.post(API_url,{
            title : title
        })

        todos.push(res.data)
        renderTodos(todos)

        console.log(res)
    } catch (error) {
        console.log(error)
    }
})

// Thay đổi trạng thái 
async function toggleStatus(id){
    try {
        //Lấy ra công việc cần cập nhật
        let todo =todos.find(todo => todo.id == id)
        let res = await axios.put(`${API_url}/${id}`,{
            title : todo.title,
            status: !todo.status
        })

        if(res.data){
            todos.forEach(todo => {
                if(todo.id==id){
                    todo.status = !todo.status
                }
            })

            renderTodos(todos)
        }

    } catch (error) {
        console.log(error)
    }
}
