var http = require('http');
var fs = require('fs');

// 웹페이지 없을때 404 만들어주기
function send404Response(response) {
response.writeHead(404,{"Content-Type": "text/plain"});
response.write("404 Error : opps~~ ");
response.end();
}
//사용자 요구에 응답처리하기

function onRequest(request ,response) {
if (request.method == 'GET' && request.url == '/') {
    response.writeHead(200,{"Content-Type": "text/html"})
    fs.createReadStream("./index.html").pipe(response);
}
else {
    //없는 파일 찾을경우
    send404Response(response);
}

}

http.createServer(onRequest).listen(8888);
console.log("서버가 돕니다");