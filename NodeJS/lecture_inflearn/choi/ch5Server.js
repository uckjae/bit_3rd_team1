var http = require('http');
var fs = require('fs');
// 웹x404
function send404Response(response) {
response.writeHead(404,{"Content-Type": "text/plain"});
response.write("404 Error : opps~~ ");
response.end();
}
//사용자 요구에 응답처리

function onRequest(request ,response) {
if (request.method == 'GET' && request.url == '/') {
    response.writeHead(200,{"Content-Type": "text/html"})
    fs.createReadStream("./index.html").pipe(response);
}
else {
    //없는파일을 찾는경우
    send404Response(response);
}
}
http.createServer(onRequest).listen(8888);
console.log("������ ���ϴ�");