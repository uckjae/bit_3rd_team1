var http = require('http');
var fs = require('fs');

// �������� ������ 404 ������ֱ�
function send404Response(response) {
response.writeHead(404,{"Content-Type": "text/plain"});
response.write("404 Error : opps~~ ");
response.end();
}
//����� �䱸�� ����ó���ϱ�

function onRequest(request ,response) {
if (request.method == 'GET' && request.url == '/') {
    response.writeHead(200,{"Content-Type": "text/html"})
    fs.createReadStream("./index.html").pipe(response);
}
else {
    //���� ���� ã�����
    send404Response(response);
}

}

http.createServer(onRequest).listen(8888);
console.log("������ ���ϴ�");