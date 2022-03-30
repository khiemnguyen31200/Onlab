const heading = document.getElementById("heading")
console.log(heading)

const para2 = document.querySelector(".para")
console.log(para2)

const para3 = document.querySelector("body > p:nth-child(4)")
console.log(para3)

//.box + ul
const ul2 = document.querySelector("body > ul")
console.log(ul2)
const ul1 = document.querySelector(".box ul")
console.log(ul1)
//body > div > ul > li:nth-child(4)
const li44 = document.querySelector(".box ul li:nth-child(4)")
console.log(li44)
//querySelectorAll
const paras = document.querySelectorAll("p")
console.log(paras)
console.log(paras[1])
console.log(paras.length)

//Duyet NodeList
for (let i = 0; i < paras.length; i++) {
    console.log(paras[i]);  
}

// Truy cap gian tiep
console.log(para3.previousElementSibling)
console.log(para3.nextElementSibling)
console.log(para3.parentElement)

//Thay doi CSS
heading.style.color="red"
heading.style.backgroundColor="black"

for (let i = 0; i < paras.length; i++) {
    paras[i].style.color="blue"
}
paras.forEach(element => {
    element.style.backgroundColor="black"
});
Array.from(paras).map(element =>{
    element.style.fontSize="30px"
})
//Lay ra noi dung
console.log(heading.innerHTML)
console.log(heading.innerText)
console.log(heading.textContent)//Giu nguyen dinh dang

console.log(ul1.innerHTML)
console.log(ul1.innerText)
console.log(ul1.textContent)
//Thay doi noi dung
heading.innerHTML="Xin chao"
heading.innerHTML="<span>Cac ban</span>"

heading.innerText="Cac ban co khoe khong"

//Tao the 
const link = document.createElement("a")
link.innerText="Google"
link.href="https://www.google.com/"
console.log(link)
//Them 1 phan tu vao DOM
// document.body.prepend(link) them vao tren cung
document.body.appendChild(link) // Them vao cuoi

const boxElement= document.querySelector(".box")
document.body.insertBefore(link,boxElement)
//Tao the li co noi dung "li new" nam truoc the li "The li 3"
const li3 = document.querySelector("body > ul > li:nth-child(3)")
const li = document.createElement("li")
li.innerText="123"
ul2.insertBefore(li,li3)

para2.insertAdjacentHTML("beforebegin","<button>Login</button>")

//Tao the 
const li0 = document.createElement("li")
li0.innerText="Li moi"
ul1.insertAdjacentElement("afterbegin",li0)
//Xoa 
document.body.removeChild(para2)
//Thay the 
const h2 = document.createElement("h2")
h2.innerText="Day la the h2"
// document.body.removeChild(h2,heading)
heading.parentElement.replaceChild(h2,heading)
//Copy 
const  boxCopy1 = boxElement.cloneNode(true)
const  boxCopy2 =boxElement.cloneNode(false)
console.log(boxCopy1)
console.log(boxCopy2)

h2.insertAdjacentElement("afterend",boxCopy1)