function deleteAuthor(id) {
    $.ajax({
        url: "http://localhost:8080/api/v1/authors/" + id,
        type: "DELETE",

        success: function (data, status, xhr) {
            window.location.replace("/admin/authors/");
        }
    })
}

function deleteEventExhibitObj() {
    let url = window.location.pathname;
    let pathArray = url.split("/");
    let eventId = pathArray[3];
    let exhibitId = $("#event-exhibits-table .selected td:first-child").text();

    $.ajax({
        url: "http://localhost:8080/api/v1/events/" + eventId + "/exhibits/" + exhibitId,
        type: "DELETE",

        success: function (data, status, xhr) {
            window.location.replace("/admin/events/" + eventId + "/exhibits/");
        }
    })
}

function addEventExhibitObj() {
    let url = window.location.pathname;
    let pathArray = url.split("/");
    let eventId = pathArray[3];
    let exhibitId = $("#exhibits-table .selected td:first-child").text();

    $.ajax({
        url: "http://localhost:8080/api/v1/events/" + eventId + "/exhibits/" + exhibitId,
        type: "POST",

        success: function (data, status, xhr) {
            window.location.replace("/admin/events/" + eventId + "/exhibits/");
        }
    })
}

function createReplaceObj() {
    let url = window.location.pathname;
    let pathArray = url.split("/");
    let exhibitId = pathArray[3];

    let obj = new Object();
    obj.comment = $("#comment-input").val();
    obj.place_id = $("#place-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/exhibits/" + exhibitId + "/places",
        type: "POST",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/exhibits/" + exhibitId + "/places");
        }
    })
}

function deleteExhibitDocument() {
    let url = window.location.pathname;
    let pathArray = url.split("/");
    let exhibitId = pathArray[3];

    let documentId = $("#exhibits-table .selected td:first-child").text();

    $.ajax({
        url: "http://localhost:8080/api/v1/exhibits/" + exhibitId + "/documents/" + documentId,
        type: "DELETE",

        success: function (data, status, xhr) {
            window.location.replace("/admin/exhibits/" + exhibitId + "/documents");
        }
    })
}

function uploadFile() {
    let file = $('#fileUploadForm')[0];
    let data = new FormData(file);

    let type = $("#type-input").val();
    data.append("type", type);

    let url = window.location.pathname;
    let pathArray = url.split("/");
    let id = pathArray[3];

    $.ajax({
        url: "http://localhost:8080/api/v1/exhibits/" + id + "/documents",
        type: "POST",
        enctype: 'multipart/form-data',
        data: data,
        cache: false,
        processData: false,
        contentType: false,
        success: function (response) {
            window.location.replace("/admin/exhibits/" + id + "/documents");
        },
        error: function (jqXHR, textStatus, errorMessage) {
            console.log(errorMessage); // Optional
        }
    });
}

function downloadFile() {
    let path = $("#exhibits-table .selected td:last-child").text().replace('web-ui/src/main/resources/static/', '');
    open("http://localhost:8080/" + path);
}
