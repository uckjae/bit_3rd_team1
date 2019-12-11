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


function about(request,response) {
    console.log("서버가 작동중")
}

function email(request,response) {
    console.log("사용자 이메일 요충중")
}
app.use("/about",about);
app.use("/email",email);

app.use(doOne);
app.use(doTwo);
http.createServer(app).listen(8888);
console.log("서버가 작동중 ");
