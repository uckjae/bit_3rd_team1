var http = require('http');

function onRequest(request ,response) {
    console.log("����ڰ� request �մϴ�." + request.url);
    response.writeHead(200,{"Context-Type" : "text/plain"});
    response.write("this is server response(data....)");
    response.end();
}

http.createServer(onRequest).listen(8888);
console.log("������ ���ϴ�");