const buttonName = document.getElementById("random-name")
const buttonHEX = document.getElementById("random-hex")
const buttonRGB = document.getElementById("random-rgb")

// buttonName.addEventListener("click",function(){
//     accessBackend(1)
// })
// buttonHEX.addEventListener("click",async function(){
//     accessBackend(2)
// })
// buttonRGB.addEventListener("click",async function(){
//     accessBackend(3)
// })
// async function accessBackend(index){
//     try {
//         let res = await axios.get(`http://localhost:8080/random-color?type=${index}`);
//         document.body.style.backgroundColor= res.data;
//     } catch (error) {
//         console.log(error)
//     }
// }

const btns = document.querySelectorAll("button")
btns.forEach((btn)=>{
    btn.addEventListener("click",async function(){
        try {
            let type = btn.dataset.type;
            let res = await axios.get(`http://localhost:8080/random-color?type=${type}`);
            document.body.style.backgroundColor= res.data;
        } catch (error) {
            console.log(error)
        }
    })
})