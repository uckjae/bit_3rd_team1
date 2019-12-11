var express = require('express');
var router = express.Router();
var jd = require("../jdata.json");
// .. 두단계 더 위로

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: `익스프레스`,
      name : `Amy`,
      jdata2 : jd });
});

module.exports = router;
