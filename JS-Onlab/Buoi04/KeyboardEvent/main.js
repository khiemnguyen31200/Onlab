// Lắng nghe sự kiện keydown
// document.addEventListener("keydown", function () {
//     console.log("keydown");
// });

// // Lắng nghe sự kiện keyup
// document.addEventListener("keyup", function () {
//     console.log("keyup");
// });

// // Lắng nghe sự kiện keypress
// document.addEventListener("keypress", function () {
//     console.log("keypress");
// });


// Lắng nghe sự kiện keydown
document.addEventListener("keydown", function (event) {
    // if(event.keyCode==13){
    //     alert("còn cái nịt")
    //     console.log("còn cái nịt")
    // }else{
    //     alert("20 củ")
    //     console.log("20 củ")
    // }
})

    const inputEL = document.querySelector("input")
    const button = document.querySelector("button")
    button.addEventListener("click",function(){
        if(inputEL.type=="password"){
            button.innerText="Hide"
            inputEL.type="text"
        }else{
            button.innerText="Show"
            inputEL.type="password"
        }
    })
    // inputEL.addEventListener("keyup",function(event){
    //         let value =event.target.value
    //         alert(`Tu khoa ban vua nhap là ${value}`)
    // })
        
    
