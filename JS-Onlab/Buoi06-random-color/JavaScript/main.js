const buttonName = document.getElementById("random-name")
const buttonHEX = document.getElementById("random-hex")
const buttonRGB = document.getElementById("random-rgb")

const inputWeight = document.getElementById("bmi-weight") 
const inputHeight = document.getElementById("bmi-height") 

const buttonGet = document.getElementById("bmi-get")
const buttonPost = document.getElementById("bmi-post")

const displayHeading= document.getElementById("bmi-result")


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

buttonGet.addEventListener("click",async function(){
try{
    let res = await axios.get(`http://localhost:8080/bmi?height=${inputHeight.value}&weight=${inputWeight.value}`);
    displayHeading.innerText=`Chỉ số BMI của bạn là :${res.data} `
}catch (error) {
    console.log(error)
}
})

buttonPost.addEventListener("click",async function(){
    try{
        let res = await axios.post(`http://localhost:8080/bmi`,{
             height : inputHeight.value,
             weight : inputWeight.value
        });
        displayHeading.innerText=`Chỉ số BMI của bạn là :${res.data} `
    }catch (error) {
        console.log(error)
    }
    })