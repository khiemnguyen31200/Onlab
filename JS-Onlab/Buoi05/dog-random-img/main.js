let btn = document.getElementById("random-btn")
let image = document.querySelector(".image img")

btn.addEventListener("click", async function () {
    try {
        //B1 gọi API
        //Cách 1 : Sử dụng fetch API mặc định
        //Cách 2 : Sử dụng axios
        let res=await axios.get("https://dog.ceo/api/breeds/image/random") 
        console.log(res)       
        //B2 Lấy kết quả từ API để gán cho image
        image.src = res.data.message

    } catch (error) {
        console.log(error.response.data.message)
    }

})