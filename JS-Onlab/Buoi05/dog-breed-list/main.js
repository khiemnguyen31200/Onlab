const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');

// Vừa load trang phải gọi API để render danh sách breed
// API : https://dog.ceo/api/breeds/list/all

async function getBreedList() {
    // Gọi API để lấy danh sách giống loài
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")
    // Sau khi có data thì hiển thị kết quả trên giao diện
    renderBreed(res.data.message)

}

function renderBreed(breeds) {
    // Duyệt qua object breeds -> tạo thẻ option -> gắn vào DOM
    // Cách 1: Sử dụng for ... in
    // Cách 2 : Lấy ra danh sách keys của objec (Object.keys) => Duyệt mảng
   for (const breed in breeds) {
       if (Object.hasOwnProperty.call(breeds, breed)) {
           const option = document.createElement("option")
           option.innerText=breed
           select.insertAdjacentElement("beforeend",option)
       }
   } 
}
getBreedList()
btn.addEventListener("click",async function(){
    let res=await axios.get(`https://dog.ceo/api/breed/${select.value}/images/random`) 
        console.log(res)       
        image.src = res.data.message
})





