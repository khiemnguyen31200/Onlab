let btntru= document.querySelector(".prevBtn")
let btncong= document.querySelector(".nextBtn")
let h1 = document.getElementById("counter")


btncong.addEventListener("click",function(){ 
    let count = Number(h1.innerText)
    h1.innerText=`${count+1}`   
    if(Number(h1.innerText)<0){
        h1.style.color="red"
    }else if(Number(h1.innerText)==0){
        h1.style.color="#333333"
    }else if(Number(h1.innerText)>0){
        h1.style.color="green"
    }
})
btntru.addEventListener("click",function(){ 
    let count = Number(h1.innerText)
    h1.innerText=`${count-1}`
    if(Number(h1.innerText)<0){
        h1.style.color="red"
    }else if(Number(h1.innerText)==0){
        h1.style.color="#333333"
    }else if(Number(h1.innerText)>0){
        h1.style.color="green"
    }
})
