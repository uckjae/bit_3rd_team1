/*6��*/

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

/*�ǿ����� ��*/

function about(request,response) {
    console.log("����ڰ� �������� ��û �Ͽ��� ����")
}

function email(request,response) {
    console.log("����ڰ� email ��û �Ͽ��� zzz")
}
app.use("/about",about);
app.use("/email",email);

app.use(doOne);
app.use(doTwo);


http.createServer(app).listen(8888);
console.log("������ �۵����̴� 1���Ե�� ");
