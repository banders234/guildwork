/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $('#create-submit').on('click', function(e) {
        e.preventDefault();
        var notesarray = [];
        $('#notes-input-group').find('input').each(function(){
            console.log(this.value);
            notesarray.push(this.value);
        });
        console.log(notesarray);
        var dvdData = JSON.stringify({
            title: $('#title-input').val(),
            releaseDate: $('#release-date-input').val(),
            director: $('#director-input').val(),
            studio: $('#studio-input').val(),
            mpaa: $('#mpaa-input').val(),
            userRating: $('#user-rating-input').val(),
            noteList: notesarray
            
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
                $('#add-form-hider').find('span').toggleClass('glyphicon-chevron-down').toggleClass('glyphicon-chevron-up');
                $('#add-dvd-form').collapse("hide");
                $('#dvd-table-container').scrollTop($('#dvd-table-container')[0].scrollHeight);
                var tableRow = buildDvdRow(data);
                $('#title-input').val("");
                $('#release-date-input').val("");
                $('#director-input').val("");
                $('#studio-input').val("");
                $('#mpaa-input').val("");
                $('#user-rating-input').val("");
                $('#dvd-table-container').append($(tableRow));
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
    $('#add-form-hider').click(function(){
        $(this).find('span').toggleClass('glyphicon-chevron-down').toggleClass('glyphicon-chevron-up');
    });
    $('#showDvdModal').on('show.bs.modal', function(e) {
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
                $('#show-dvd-id').val(data.id);
                document.getElementById("relink-button").setAttribute('data-dvd-id', data.id);
                if (data.imdbId === null) {
                    $('#imdb-info-container').hide();
                    $('#imdb-dvd-table').hide();
                    $('#dvd-poster').hide();
                    $('#show-dvd-table').show();
                    $('#dvd-title').text(data.title);
                    $('#imdb-title').text(data.title);
                    $('#dvd-release-date').text(data.releaseDate);
                    $('#dvd-mpaa').text(data.mpaa);
                    $('#dvd-user-rating').text(data.userRating);
                    $('#dvd-director').text(data.director);
                    $('#dvd-studio').text(data.studio);
                    var noteList = data.noteList;
                    for (i = 0; i< noteList.length; i++) {
                        var count = i+1;
                        var noteRow = buildNoteRow(noteList[i], count);
                        $('#show-dvd-table').append($(noteRow));
                    }
                    $('#relink-button').val(data.title);
                }
                else {
                    $('#show-dvd-table').hide();
                    $('#imdb-info-container').show();
                    $('#imdb-dvd-table').show();
                    $('#dvd-poster').show();
                    $('#imdb-footer').show();
                    $('#dvd-poster').html("<img src='" + data.posterLink + "' height='150px' width='100px' />");
                    $('#imdb-title').html(data.title);
                    var genre = "";
                    var genreList = data.genreList;
                    for (i = 0; i < genreList.length; i++) {
                        if (i + 1 !== genreList.length) {
                            genre += genreList[i] += ", ";
                        }
                        else {
                            genre += genreList[i];
                        }
                    };
                    $('#imdb-genre').html(genre);
                    $('#imdb-mpaa').html(data.mpaa);
                    $('#imdb-plot').html(data.plot);
                    $('#imdb-director').html(data.director);
                    $('#imdb-metascore').html(data.metascore);
                    $('#imdb-votes').html(data.imdbVotes);
                    $('#imdb-rating').html(data.imdbRating);
                    $('#imdb-actors').html(data.actors);
                    $('#imdb-date').html(data.releaseDate);
                    $('#imdb-awards').html(data.awards);
                    if (data.studio !== null) {
                        $('#imdb-studio').text(data.studio);
                    }
                    else {
                        $('#imdb-studio').text("N/A");
                    }
                    if (data.userRating !== 0) {
                        $('#imdb-user-rating').text(data.userRating);
                    }
                    else {
                        $('#imdb-user-rating').text("N/A");
                    }
                    $('#relink-button').val(data.title);
                    var noteList = data.noteList;
                    for (i = 0; i< noteList.length; i++) {
                        var count = i+1;
                        var noteRow = buildNoteRow(noteList[i], count);
                        $('#imdb-dvd-table').append($(noteRow));
                    }
                }
            }
        });
    });
    
    var notecounter = 1;
    var editnotecounter = 1;
    $('#editDvdModal').on('show.bs.modal', function(e) {
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
                var noteList = data.noteList;
                $('#dvd-id').val(data.id);
                $('#edit-dvd-title').val(data.title);
                $('#edit-dvd-release-date').val(data.releaseDate);
                $('#edit-dvd-director').val(data.director);
                $('#edit-dvd-studio').val(data.studio);
                $('#edit-dvd-mpaa').val(data.mpaa);
                $('#edit-dvd-user-rating').val(data.userRating);
                $('#edit-notes-input-1').val(noteList[0]);
                if (noteList.length > 1) {
                    $('#edit-notes-buttons-1').remove();
                }
                for (i = 1; i< noteList.length; i++) {
                    editnotecounter++;
                    var html = "<th>Note " + editnotecounter + ":</th> \n\
                            <td id='edit-notes-cell-" + editnotecounter + "'> \n\
                                <div class='col-md-8'> \n\
                                    <input class='form-control' value='" + noteList[editnotecounter-1] + "'id='edit-notes-input-1'/> \n\
                                </div> \n\
                            </td>";
                    addElement("edit-notes-group", "tr", "edit-notes-" + editnotecounter, html);
                }
                if (noteList.length > 1) {
                    var buttonhtml = "<div id='edit-notes-buttons-" + editnotecounter + "' class='col-md-4'> \n\
                                        <button type='button' class='btn btn-primary btn-circle' id='add-edit-notes-input' aria-label='Left Align'> \n\
                                            <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                        </button> \n\
                                        <button type='button' class='btn btn-danger btn-circle' id='remove-edit-notes-input' aria-label='Left Align'> \n\
                                            <span class='glyphicon glyphicon-minus' aria-hidden='true'></span> \n\
                                        </button>  \n\
                                    </div>";
                    addElement("edit-notes-cell-"+ editnotecounter, "div",'edit-notes-buttons-'+ editnotecounter, buttonhtml);
                }
            },    
            error: function(data, status) {
                alert("error");
            }
        
        });
    });
    $('#editDvdModal').on('hidden.bs.modal', function(e) {
        e.preventDefault();
        while (editnotecounter > 1) {
            $('#edit-notes-' + editnotecounter).remove();
            editnotecounter--;
        }
    });
    $('#linkDvdModal').on('hidden.bs.modal', function(e) {
        e.preventDefault();
        $('.link-table-row').remove();
        $('#link-dvd-id').val('');
    });
    $(document).on('click', '.imdb-link-button', function(e) {
        e.preventDefault();
        var imdbId = this.value;
        var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        ];
        var dvdData;
        var xhr = $.getJSON("http://www.omdbapi.com/?i="+imdbId,function(data) { 
            var releaseDate = data['Released'];
            var monthNumber = monthNames.indexOf(releaseDate.substring(3,6))+1;
            releaseDate=releaseDate.substring(7,11)+"-"+monthNumber+"-"+releaseDate.substring(0,3);
            console.log(releaseDate);
            var imdbVotes = data['imdbVotes'].replace(/\,/g,'');
            var genre = data['Genre'];
            var genreArray = genre.split(", ");
            console.log(genreArray);
            dvdData = JSON.stringify({
                
                posterLink: data['Poster'],
                title: data['Title'],
                director: data['Director'],
                mpaa: data['Rated'],
                actors: data['Actors'],
                releaseDate: releaseDate,
                metascore: data['Metascore'],
                plot: data['Plot'],
                genreList: genreArray,
                country: data['Country'],
                imdbVotes: imdbVotes,
                imdbRating: data['imdbRating'],
                awards: data['Awards'],
                id: $('#link-dvd-id').val(),
                imdbId: imdbId
            });
            console.log(dvdData);
        $.ajax({
            
            url: contextRoot + "/dvd/link",
            type: "PUT",
            data: dvdData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                $('#linkDvdModal').modal('hide');
                var tableRow = buildDvdRow(data);
                
                $('#dvd-row-' + data.id).replaceWith( $(tableRow) );
            },
            error: function(data, status) {
               var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                alert(validationError.fieldName + ": " + validationError.message);
                });
            }
        });
        });
        
    });
    $(document).on('click', '.imdb-link-search-button', function(e) {
        e.preventDefault();
        var imdbId = this.value;
        var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        ];
        var dvdData;
        var xhr = $.getJSON("http://www.omdbapi.com/?i="+imdbId,function(data) { 
            var releaseDate = data['Released'];
            var monthNumber = monthNames.indexOf(releaseDate.substring(3,6))+1;
            releaseDate=releaseDate.substring(7,11)+"-"+monthNumber+"-"+releaseDate.substring(0,3);
            console.log(releaseDate);
            var imdbVotes = data['imdbVotes'].replace(/\,/g,'');
            var genre = data['Genre'];
            var genreArray = genre.split(", ");
            console.log(genreArray);
            dvdData = JSON.stringify({
                
                posterLink: data['Poster'],
                title: data['Title'],
                director: data['Director'],
                mpaa: data['Rated'],
                actors: data['Actors'],
                releaseDate: releaseDate,
                metascore: data['Metascore'],
                plot: data['Plot'],
                genreList: genreArray,
                country: data['Country'],
                imdbVotes: imdbVotes,
                imdbRating: data['imdbRating'],
                awards: data['Awards'],
                id: $('#link-dvd-id').val(),
                imdbId: imdbId
            });
            console.log(dvdData);
        $.ajax({
            
            url: contextRoot + "/dvd/search/link",
            type: "POST",
            data: dvdData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                var divId = '#imdb-link-search-'+data.imdbId;
                $(divId).html("<span style='color:#00FF00; font-size: 150%;' class='glyphicon glyphicon-check'></span>");
            },
            error: function(data, status) {
               var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                alert(validationError.fieldName + ": " + validationError.message);
                });
            }
        });
        });
        
    });
    $('#edit-dvd-button').on('click', function(e) {
        
        e.preventDefault();
        var notesarray = [];
        $('#edit-notes-group').find('input').each(function(){
                console.log(this.value);
                notesarray.push(this.value);
        });
        var dvdData = JSON.stringify({
            
            title: $('#edit-dvd-title').val(),
            director: $('#edit-dvd-director').val(),
            studio: $('#edit-dvd-studio').val(),
            userRating: $('#edit-dvd-user-rating').val(),
            mpaa: $('#edit-dvd-mpaa').val(),
            noteList: notesarray,
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
    $('#relink-button').on('click', function(e) {
        $('#showDvdModal').modal('hide');
        $('#link-table-container').show();
        $('#link-dvd-table').show();
        $('#imdb-info-container').hide();
        $('#imdb-dvd-table').hide();
        $('#dvd-poster').hide();
        $('#imdb-footer').show();
        var dvdId  = $('#show-dvd-id').val();
        $("#link-dvd-id").val(dvdId);
        var uri = encodeURIComponent(this.value);
        var xhr = $.getJSON("http://www.omdbapi.com/?s="+uri,function(data) { 
            var searchResults = data["Search"];
            console.log(searchResults);
            for (i=0; i<searchResults.length; i++) {
                $('#link-dvd-table').append(buildLinkDvdRow(searchResults[i]));
            }
        });
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
    
    $(document).on('click', '#add-edit-notes-input', function(e) {
        editnotecounter++;
        e.preventDefault();
        var html = "<th>Note " + editnotecounter + ":</th> \n\
                            <td id='edit-notes-cell-" + editnotecounter + "'> \n\
                                <div class='col-md-8'> \n\
                                    <input class='form-control' id='notes-input-1'/> \n\
                                </div> \n\
                                <div id='edit-notes-buttons-" + editnotecounter + "' class='col-md-4'> \n\
                                    <button type='button' class='btn btn-primary btn-circle' id='add-edit-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                    </button> \n\
                                    <button type='button' class='btn btn-danger btn-circle' id='remove-edit-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-minus' aria-hidden='true'></span> \n\
                                    </button>  \n\
                                </div> \n\
                            </td>";
        addElement("edit-notes-group", "tr", "edit-notes-" + editnotecounter, html);
        var lastnote=editnotecounter-1;
        removeElement("edit-notes-buttons-" + lastnote);
    });
    $(document).on('click', '#remove-edit-notes-input', function(e) {
        e.preventDefault();
        removeElement('edit-notes-' + editnotecounter);
        editnotecounter--;
        var html = "";
        if (editnotecounter === 1) {
            html = "<div class='col-md-4' id='edit-notes-buttons-" + editnotecounter + "'> \n\
                                    <button type='button' class='btn btn-primary btn-circle' id='add-edit-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                    </button> \n\
                                </div>";
        }
        else {
            html = "<div class='col-md-4' id='edit-notes-buttons-" + editnotecounter + "'> \n\
                                    <button type='button' class='btn btn-primary btn-circle' id='add-edit-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                    </button> \n\
                                    <button type='button' class='btn btn-danger btn-circle' id='remove-edit-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-minus' aria-hidden='true'></span> \n\
                                    </button>            \n\
                                </div>";
        }
        addElement("edit-notes-cell-"+ editnotecounter, "div",'edit-notes-buttons-'+ editnotecounter, html);
    });
    $(document).on('click', '#add-notes-input', function(e) {
        notecounter++;
        e.preventDefault();
        var html = "<label class='col-md-4 control-label' for='notes'>Note " + notecounter + ":</label> \n\
                            <div class='col-md-6'> \n\
                                <input class='form-control' id='notes-input-" + notecounter + "'/> \n\
                            </div> \n\
                            <div class='col-md-2' id='notes-buttons-" + notecounter + "'> \n\
                                <button type='button' class='btn btn-primary btn-circle' id='add-notes-input' aria-label='Left Align'> \n\
                                    <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                </button> \n\
                                <button type='button' class='btn btn-danger btn-circle' id='remove-notes-input' aria-label='Left Align'> \n\
                                    <span class='glyphicon glyphicon-minus' aria-hidden='true'></span> \n\
                                </button>            \n\
                            </div>";
        addElement("notes-input-group", "div", "notes-" + notecounter, html);
        var lastnote=notecounter-1;
        console.log("notes-buttons-" + notecounter);
        removeElement("notes-buttons-" + lastnote);
    });
    $('#showDvdModal').on('hidden.bs.modal', function(e) {
        e.preventDefault();
        $(".show-note").remove();
    });
    $(document).on('click', '#remove-notes-input', function(e) {
        e.preventDefault();
        removeElement('notes-' + notecounter);
        notecounter--;
        var html = "";
        if (notecounter === 1) {
            html = "<div class='col-md-2' id='notes-buttons-" + notecounter + "'> \n\
                                    <button type='button' class='btn btn-primary btn-circle' id='add-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                    </button> \n\
                                </div>";
        }
        else {
            html = "<div class='col-md-2' id='notes-buttons-" + notecounter + "'> \n\
                                    <button type='button' class='btn btn-primary btn-circle' id='add-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> \n\
                                    </button> \n\
                                    <button type='button' class='btn btn-danger btn-circle' id='remove-notes-input' aria-label='Left Align'> \n\
                                        <span class='glyphicon glyphicon-minus' aria-hidden='true'></span> \n\
                                    </button>            \n\
                                </div>";
        }
        addElement("notes-"+ notecounter, "div",'notes-buttons-'+ notecounter, html);
    });
    function addElement(parentId, elementTag, elementId, html) {
        // Adds an element to the document
        var p = document.getElementById(parentId);
        var newElement = document.createElement(elementTag);
        newElement.setAttribute('id', elementId);
        newElement.innerHTML = html;
        p.appendChild(newElement);
    }
    function removeElement(elementId) {
        // Removes an element from the document
        var element = document.getElementById(elementId);
        element.parentNode.removeChild(element);
    }
    function buildNoteRow(note, count) {
        return "<tr  class='show-note' id='show-note-" + count + "'> \n\
            <th class='imdb-table-left'>Note " + count + "</th> \n\
            <td>" + note + "</td> \n\
            <tr>";
                    
    }
    function buildDvdRow(data) {
        var posterlink;
        if (data.posterLink === null) {
            posterlink = "/DVDLibrary/img/noposter.jpg";
        }
        else {
            posterlink = data.posterLink;
        }
        console.log(data.releaseDate);
        console.log(data.releaseDate.substring(0,4));
        return "<div class='col-md-4 col-lg-4 dvd-container' id='dvd-row-" + data.id + "'> \n\
                                    <div class='col-md-6 col-lg-6'> \n\
                                        <a data-dvd-id='" + data.id + "' href='#' data-toggle='modal' data-target='#showDvdModal'><img class='img-responsive' src='" + posterlink + "' alt='No Poster Available' height='450px' width='300px'/></a> \n\
                                    </div> \n\
                                    <div class='col-md-6 col-lg-6'> \n\
                                            <div class='panel panel-primary'> \n\
                                                <div class='panel-heading'>" + data.title + "</div> \n\
                                                <div class='panel-body'> \n\
                                                    <div>" + data.releaseDate.substring(0,4) + "</div> \n\
                                                    <div><a data-dvd-id='" + data.id + "' class='glyphicon glyphicon-pencil' href='#' data-toggle='modal' data-target='#editDvdModal'></a></div> \n\
                                                    <div> \n\
                                                        <button class='btn btn-link delete-link glyphicon glyphicon-trash' data-dvd-id='" + data.id + "'> \n\
                                                        </button> \n\
                                                    </div> \n\
                                                </div> \n\
                                            </div> \n\
                                    </div> \n\
                                </div>";
        
    }
    function buildLinkDvdRow(data) {
        return "<tr class='link-table-row'> \n\
                    <td>\n\
                        <div class='poster-link-container'>\n\
                            <img src='" + data['Poster'] + "' alt='"  + data['Title'] + "' height='90px' width='60px'/>\n\
                        </div> \n\
                        <div class='imdb-link-container'> \n\
                            <button class='btn btn-success imdb-link-button' value='" + data['imdbID'] + "'>Link</button>\n\
                        </div> \n\
                    </td>\n\
                    <td>" + data['Title']+ "<br>Year of release: " + data['Year'] + "<br>Imdb ID: " + data['imdbID'] + "</td> \n\
                </tr>";
    }
});

