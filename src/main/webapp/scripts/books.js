var bookGrid;

dhtmlxEvent(window, "load", function() {
    bookGrid = new dhtmlXGridObject("book_grid_container");
    
    bookGrid.setImagePath("codebase/imgs/");
    bookGrid.setHeader("Name, Year, Genre, Author, Description");
    bookGrid.setInitWidths("300, 100, 100, 100, 200");
    bookGrid.setColAlign("left, center, center, left, left");
    bookGrid.setSkin("material");
    bookGrid.setColSorting("str, num, str, str, str");
    
    bookGrid.init();
});

function loadBooks() {
    var XHR = ("onload" in new XMLHttpRequest()) ? XMLHttpRequest : XDomainRequest;
    var xhr = new XHR();
    
    xhr.open('GET', 'http://localhost:8888/api/book', true);
    
    xhr.onload = function() {
        bookGrid.clearAll();
        var responseData = JSON.parse(this.responseText);
        
        responseData.forEach(function (element, index, array) {
           
            var newId = (new Date()).valueOf();
            
            bookGrid.addRow(
                newId,
                element.name + "," + element.year + ","
                    + element.genre + ","
                    + (element.author ? element.author.lastName : null) + ","
                    + element.description,
                bookGrid.getRowsNum()
            );
            
            bookGrid.selectRowById(newId);
        });
    }
    
    xhr.onerror = function() {
        alert(this.status + ': ' + this.statusText);
    }
    
    xhr.send();
}
