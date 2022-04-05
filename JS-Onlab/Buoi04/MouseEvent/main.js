
// document.addEventListener('mousedown', function () {
//     console.log('mousedown');
// })

// document.addEventListener('mousemove', function () {
//     console.log('mousemove');
// })

// document.addEventListener('mouseup', function () {
//     console.log('mouseup');
// })

document.addEventListener("click", function (event) {
    //Xóa hình cũ
    boxEl = document.querySelector(".box")
    if(boxEl){
        boxEl.parentElement.removeChild(boxEl)
    }
    //B1 Tao box
    box.classList.add("box")

    //B2 Set vị trí cho box
    box.style.left =`${event.offsetX-50}px`;
    box.style.top =`${event.offsetY-50}px`;
    //B3 Gắn vào DOM
    document.body.appendChild(box);

})