<html>
<body>
<h2>Hello World!</h2>

$.ajax({
    url: "http://otter.topsy.com/urlinfo.js?url=http://www.nytimes.com",
    dataType: 'jsonp',
    success: function(results){
        console.log(results);
    }
});
</body>
</html>
