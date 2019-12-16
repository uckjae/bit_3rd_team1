/*6강*/

var connect = require('connect');
var http = require('http');

var app = connect();

function doOne(request,response ,next ) {
    console.log("do one")
        next();
}

function doTwo(request,response) {
    console.log("do two")
}

/*실용적인 예*/

function about(request,response) {
    console.log("사용자가 페이지를 요청 하였움 ㅎㅎ")
}

function email(request,response) {
    console.log("사용자가 email 요청 하였움 zzz")
}
app.use("/about",about);
app.use("/email",email);

app.use(doOne);
app.use(doTwo);


http.createServer(app).listen(8888);
console.log("서버가 작동중이다 1조님들아 ");
