function updateExhibitObj() {
    let obj = new Object();
    obj.id = $("#id-input").attr("value");
    obj.name = $("#name-input").val();
    obj.description = $("#description-input").val();
    obj.code = $("#code-input").val();
    obj.author_id = $("#author-input").val();
    obj.type_id = $("#type-input").val();
    obj.storage_condition_id = $("#storage-condition-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/exhibits",
        type: "PUT",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/exhibits");
        }
    })
}

function createExhibitObj() {
    let obj = new Object();
    obj.name = $("#name-input").val();
    obj.description = $("#description-input").val();
    obj.author_id = $("#author-input").val();
    obj.type_id = $("#type-input").val();
    obj.storage_condition_id = $("#storage-condition-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/exhibits",
        type: "POST",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/exhibits");
        }
    })
}

function createAuthorObj() {
    let obj = new Object();
    obj.name = $("#name-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/authors",
        type: "POST",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/authors");
        }
    })
}

function updateAuthorObj() {
    let obj = new Object();
    obj.id = $("#id-input").attr("value");
    obj.name = $("#name-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/authors",
        type: "PUT",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/authors");
        }
    })
}

function updateEventObj() {
    let obj = new Object();
    obj.id = $("#id-input").attr("value");
    obj.name = $("#name-input").val();
    obj.description = $("#description-input").val();
    obj.start = $("#start-input").val();
    obj.end = $("#end-input").val();
    obj.type_id = $("#type-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/events",
        type: "PUT",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/events");
        }
    })
}

function createEventObj() {
    let obj = new Object();
    obj.name = $("#name-input").val();
    obj.description = $("#description-input").val();
    obj.start = $("#start-input").val();
    obj.end = $("#end-input").val();
    obj.type_id = $("#type-input").val();

    let json = JSON.stringify(obj);
    $.ajax({
        url: "http://localhost:8080/api/v1/events",
        type: "POST",
        data: json,
        contentType: 'application/json',

        success: function (data, status, xhr) {
            window.location.replace("/admin/events");
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