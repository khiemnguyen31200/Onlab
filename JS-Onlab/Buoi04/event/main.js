
p = document.querySelector("p")
// Sử dụng HTML Attribute - gọi hàm xử lí sự kiện ngay trong HTML
//Bai 1
function changeContent(){
    p.innerText="Có chí thì nên"
}

//Sử dụng DOM property
//Bai 2
function getRandomRGB(){
    const r = Math.floor(Math.random()*255);
    const g = Math.floor(Math.random()*255);
    const b = Math.floor(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`;
  };
function getNewColor(){
 p.style.color =getRandomRGB()
}  
const btn2 = document.getElementById("btn-2")
btn2.onclick = getNewColor


//Sử dụng addEventListener
//Bài 3
const toHexa = (v) => v.toString(16).padStart(2, "0");
function getRandomHEX(){
    const r = Math.floor(Math.random()*255);
    const g = Math.floor(Math.random()*255);
    const b = Math.floor(Math.random()*255);
    return `#${toHexa(r)}${toHexa(g)}${toHexa(b)}`;
  };
const btn3 = document.getElementById("btn-3")
btn3.addEventListener("click",function(){
    p.style.backgroundColor=getRandomHEX()
})


