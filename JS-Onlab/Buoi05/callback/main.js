function doTask01(name,callback){
    console.log("Bắt đầu công việc")
    console.log(`Thuc hiện công việc ${name}`)
    setTimeout(function(){
        callback()
    },3000)
}

function doTask02(name,callback){
    console.log(` THực hiện công việc ${name}`)
    setTimeout(function(){
        callback()
    },3000)
}

function doTask03(name,callback){
    console.log(`THực hiện công việc ${name}`)
    setTimeout(function(){
        callback()
    },3000)
}
function finish(){
    console.log("Kết thúc")
}
doTask01("Do homework", finish)

//Thực hiện nối tiếp
doTask01("Làm bài tập",function(){
    doTask02("Nấu cơm",function(){
        doTask03("Đá bóng",finish)
    })
})

//Thực hiện song song
doTask03("Chơi Game",finish)