/*var http = require('http');

var fs = require('fs');//파일 시스템 모듈 호출

//웹페이지 없을 때 404 response
function send404Response(response) {
    response.writeHead(404,{"Content-Type":"text/plain"});
    response.write("404 Error : Opps!!");
    response.end();
}

//사용자 요구에 응답 처리하기
function onRequest(request, response){
    if(request.method == "GET" && request.url =="/"){
        response.writeHead(200,{"Content-Type":"text/html"});
        fs.createReadStream("./index.html").pipe(response);
    }
    else{
        //없는 파일을 찾는 경우
        send404Response(response);
    }
}

/!*function onRequest(requset, response){
    console.log("사용자가 request 합니다" + requset.url);
    response.writeHead(200,{"Context-Type": "text/plain"});
    response.write("this is server response(data...)");
    response.end();
}*!/

http.createServer(onRequest).listen(8888);
console.log("서버가 돕니다");*/

var connect = require('connect');
var http = require('http');

var app = connect();

/*function doOne(request,response,next){
    console.log("do one");
    next();
}

function doTwo(request,response){
    console.log("do two");

}

app.use(doOne);
app.use(doTwo);*/

function about(request,response){
    console.log('사용자가 about 페이지를 요청했습니다')
}
function email(request,response){
    console.log('사용자가 email 페이지를 요청했습니다');
}

app.use('/about',about);
app.use('/email',email);
http.createServer(app).listen(8888);
console.log("서버가 작동 중이다");

