const heading = document.querySelector("h1")
console.log(heading.classList)
heading.classList.add("text-uppercase","text-center")
heading.classList.remove("text-center")
console.log(heading.classList.contains('text-red')); // true
console.log(heading.classList.contains('text-big')); // false
//Thuc hien 1 cong viec sau 1 khoang thoi gian nhat dinh
setInterval(function(){
    heading.classList.toggle("text-center")
},200)