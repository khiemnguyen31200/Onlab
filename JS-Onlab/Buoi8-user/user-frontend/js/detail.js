const API_URL = "http://localhost:8080/users"
const params = new URLSearchParams(window.location.search)
const id = params.get("id")
const nameEl = document.getElementById("fullname")
const emailEl = document.getElementById("email")
const phoneEl = document.getElementById("phone")
const addressEl = document.getElementById("address")
const btnBack = document.querySelector(".btn-back")
btnBack.addEventListener("click", function () {
    //Điều hướng trong js
    window.location.href = "/user-frontend/"
})

const getUser = async id => {
    try {
        let res = await axios.get(`${API_URL}/${id}`)
        renderUser(res.data)
    } catch (error) {
        console.log(error)
    }
}
getUser(id)

const getCity = async () => {
    try {
        let res = await axios.get(`https://provinces.open-api.vn/api/p/`)
        renderCity(res.data)
    } catch (error) {
        console.log(error)
    }
}

const renderCity = arr => {
    let html = ""
    for (let i = 0; i < arr.length; i++) {
        const d = arr[i]
        html += `<option value="${d.name}">${d.name}</option>`
    }
    addressEl.innerHTML = html
}
getCity()

//Render User 
const renderUser = user => {
    nameEl.value = user.name
    emailEl.value = user.email
    phoneEl.value = user.phone
    addressEl.value = user.address
}

const init = async () => {
    await getCity()
    await getUser()
}
init()