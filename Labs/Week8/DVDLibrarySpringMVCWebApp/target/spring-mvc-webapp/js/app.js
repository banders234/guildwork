/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('#create-submit').on('click', function(e) {
        
        e.preventDefault();
        
        var dvdData = JSON.stringify({
            title: $('#title-input').val(),
            releaseDate: $('#release-date-input').val(),
            director: $('#director-input').val(),
            studio: $('#studio-input').val(),
            mpaa: $('#mpaa-input').val(),
            userRating: $('#user-rating-input').val(),
            notes: $('#notes-input').val()
            
        });
        
        $.ajax({
            
            url: contextRoot + "/dvd",
            type: "POST",
            data: dvdData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                alert("success");
                
                var tableRow = buildDvdRow(data);
                
                $('#dvd-table').append($(tableRow));
            },
            error: function(data, status) {
                var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                $('#add-contact-validation-errors').append(validationError.fieldName + ": " + validationError.message).append("<br/>");
                });
            }
        });
        
        //alert("alert after ajax");
    });
    $('#showDvdModal').on('show.bs.modal', function(e) {
        console.log("go there");
        var link = $(e.relatedTarget);
        
        var dvdId = link.data('dvd-id');
        
        $.ajax({ 
        
            url: contextRoot + "/dvd/" + dvdId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#dvd-title').text(data.title);
                $('#dvd-release-date').text(data.releaseDate);
                $('#dvd-mpaa').text(data.mpaa);
                $('#dvd-user-rating').text(data.userRating);
                $('#dvd-director').text(data.director);
                $('#dvd-studio').text(data.studio);
                $('#dvd-notes').text(data.notes);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    $('#editDvdModal').on('show.bs.modal', function(e) {
        console.log("go there");
        var link = $(e.relatedTarget);
        
        var dvdId = link.data('dvd-id');
        
        $.ajax({ 
        
            url: contextRoot + "/dvd/" + dvdId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#edit-dvd-title').val(data.title);
                $('#edit-dvd-director').val(data.director);
                $('#edit-dvd-studio').val(data.studio);
                $('#edit-dvd-user-rating').val(data.userRating);
                $('#edit-dvd-mpaa').val(data.mpaa);
                $('#edit-dvd-notes').val(data.notes);
                $('#edit-dvd-release-date').val(data.releaseDate);
                $('#dvd-id').val(data.id);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    
    $('#edit-dvd-button').on('click', function(e) {
        
        e.preventDefault();
        
        var dvdData = JSON.stringify({
            title: $('#edit-dvd-title').val(),
            director: $('#edit-dvd-director').val(),
            studio: $('#edit-dvd-studio').val(),
            userRating: $('#edit-dvd-user-rating').val(),
            mpaa: $('#edit-dvd-mpaa').val(),
            notes: $('#edit-dvd-notes').val(),
            releaseDate: $('#edit-dvd-release-date').val(),
            id: $('#dvd-id').val()
        });
        
        $.ajax({
            
            url: contextRoot + "/dvd",
            type: "PUT",
            data: dvdData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                
                $('#editDvdModal').modal('hide');
                
                var tableRow = buildDvdRow(data);
                
                $('#dvd-row-' + data.id).replaceWith( $(tableRow) );
            },
            error: function(data, status) {
               alert("error");
            }
        });
        
        //alert("alert after ajax");
        
    });
    
    $(document).on('click', '.delete-link', function(e) {
        e.preventDefault();
        
        var dvdId = $(e.target).data('dvd-id');
        
        $.ajax({
            type: "DELETE",
            url: contextRoot + "/dvd/" + dvdId,
            success: function(data, status) {
                $('#dvd-row-' + dvdId).remove();
            },
            error: function(data, status) {
                
            }
        });
    });
    function buildDvdRow(data) {
        return "<tr id='dvd-row-" + data.id + "'>  \n\
                <td> " + data.releaseDate + "</td>    \n\
                <td><a data-dvd-id='" + data.id +"' data-toggle='modal' data-target='#showDvdModal'>" + data.title + "</a></td>  \n\
                <td> <a data-dvd-id='" + data.id +"' data-toggle='modal' data-target='#editDvdModal'>Edit</a>  </td>   \n\
                <td> <a data-dvd-id='" + data.id +"' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";
        
    }
});

