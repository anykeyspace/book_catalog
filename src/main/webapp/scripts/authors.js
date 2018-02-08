var authorGrid;

dhtmlxEvent(window, "load", function() {
    authorGrid = new dhtmlXGridObject("author_grid_container");

    authorGrid.setImagePath("codebase/imgs/");
    authorGrid.setHeader("First name,Last name,Country,Books");
    authorGrid.setInitWidths("150,150,150,*");
    authorGrid.setColAlign("left,left,center,center");
    authorGrid.setSkin("material");
    authorGrid.setColSorting("str,str,str,na");

    authorGrid.init();

/*
    Ajax.Responders.register({
      onCreate: function(){
        alert('a request has been initialized!');
      },
      onComplete: function(){
        alert('a request completed');
      }
    });
*/
});

function addAuthor() {
    var newId = (new Date()).valueOf(); // creates a unique row id
    authorGrid.addRow(newId, "First name,Last name,Country", authorGrid.getRowsNum());
    authorGrid.selectRowById(newId);
}

function removeAuthor() {
    var selId = authorGrid.getSelectedId();
    authorGrid.deleteRow(selId);
}

function loadAuthors() {
    var XHR = ("onload" in new XMLHttpRequest()) ? XMLHttpRequest : XDomainRequest;
    var xhr = new XHR();

    xhr.open('GET', 'http://localhost:8888/api/author', true);

    xhr.onload = function() {
        authorGrid.clearAll();
        var responseData = JSON.parse(this.responseText);

        responseData.forEach(function (element, index, array) {

            var newId = (new Date()).valueOf();

            authorGrid.addRow(
                newId,
                element.firstName + "," + element.lastName + ","
                    + element.country + "," + element.books,
                authorGrid.getRowsNum()
            );

            authorGrid.selectRowById(newId);
        });
    }

    xhr.onerror = function() {
        alert(this.status + ': ' + this.statusText);
    }

    xhr.send();
}

function loadAuthorsPrototype() {
    var ajaxRequest = new Ajax.Request('http://localhost:8888/api/author', {
        method: 'GET',
        requestHeaders: {Accept: 'application/json'},
        onSuccess: function(transport) {
            var json = transport.responseText.evalJSON(true);
            alert("Success! \n\n" + json);

            console.log(json);

            authorGrid.clearAll();

            json.forEach(function (element, index, array) {

                var newId = (new Date()).valueOf();

                authorGrid.addRow(
                    newId,
                    element.firstName + "," + element.lastName + ","
                        + element.country + "," + element.books,
                    authorGrid.getRowsNum()
                );

                authorGrid.selectRowById(newId);
            });

        },
        onFailure: function() {
            alert("Something problem.");
        }
    });

}
