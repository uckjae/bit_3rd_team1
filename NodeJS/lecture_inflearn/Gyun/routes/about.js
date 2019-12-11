var express = require('express');
var router = express.Router();

/* GET about page. */
router.get('/', function(req, res, next) {
  res.render('about', { title: `Emiya`, name : `gook yee zza da`});
});

module.exports = router;
