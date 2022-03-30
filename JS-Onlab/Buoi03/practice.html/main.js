//Truy cập vào thẻ h1 có id=“heading” thay đổi màu chữ thành ‘red’, và in hoa nội dung của thẻ đó
const heading =document.getElementById("heading")
heading.style.color="red"
heading.style.textTransform ="uppercase"
//Thay đổi màu chữ của tất cả thẻ có class “para” thành màu “blue” và có font-size = “20px”
const paras = document.querySelectorAll(".para")
paras.forEach(element => {
    element.style.color="blue"
    element.style.fontSize="30px"
});
//Thêm thẻ a link đến trang ‘facebook’ ở đằng sau thẻ có class “para-3”
const link =document.createElement("a")
link.href="https://www.facebook.com/"
link.innerText="facebook"
const para3 = document.querySelector(".para-3")
para3.appendChild(link)
//Thay đổi nội dung của thẻ có id=“title” thành “Đây là thẻ tiêu đề”
const h2 =document.getElementById("title")
h2.innerText="Đây là thẻ tiêu đề"
//Thay thế thẻ có class=“para-3” thành thẻ button có nội dung là “Click me”