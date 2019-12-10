var http = require('http');

function onRequest(request ,response) {
    console.log("사용자가 request 합니다." + request.url);
    response.writeHead(200,{"Context-Type" : "text/plain"});
    response.write("this is server response(data....)");
    response.end();
}

http.createServer(onRequest).listen(8888);
console.log("서버가 돕니다");