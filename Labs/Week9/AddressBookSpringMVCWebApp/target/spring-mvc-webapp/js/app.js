/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('#create-submit').on('click', function(e) {
        
        e.preventDefault();
        
        var addressData = JSON.stringify({
            firstName: $('#first-name-input').val(),
            lastName: $('#last-name-input').val(),
            city: $('#city-input').val(),
            streetNumber: $('#street-number-input').val(),
            streetName: $('#street-name-input').val(),
            state: $('#state-input').val(),
            zip: $('#zip-input').val()
            
            
        });
        
        $.ajax({
            
            url: contextRoot + "/address",
            type: "POST",
            data: addressData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                alert("success");
                
                var tableRow = buildAddressRow(data);
                $('#address-first-name').val("");
                $('#address-last-name').val("");
                $('#address-street-number').val("");
                $('#address-street-name').val("");
                $('#address-city').val("");
                $('#address-state').val("");
                $('#address-zip').val("");
                $('#address-table').append($(tableRow));
                
            },
            error: function(data, status) {
                alert("error");
            }
        });
        
        //alert("alert after ajax");
    });
    $('#showAddressModal').on('show.bs.modal', function(e) {
        console.log("go there");
        var link = $(e.relatedTarget);
        
        var addressId = link.data('address-id');
        
        $.ajax({ 
        
            url: contextRoot + "/address/" + addressId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#address-first-name').text(data.firstName);
                $('#address-last-name').text(data.lastName);
                $('#address-street-number').text(data.streetNumber);
                $('#address-street-name').text(data.streetName);
                $('#address-city').text(data.city);
                $('#address-state').text(data.state);
                $('#address-zip').text(data.zip);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    $('#editAddressModal').on('show.bs.modal', function(e) {
        console.log("go there");
        var link = $(e.relatedTarget);
        
        var addressId = link.data('address-id');
        
        $.ajax({ 
        
            url: contextRoot + "/address/" + addressId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#edit-address-first-name').val(data.firstName);
                $('#edit-address-last-name').val(data.lastName);
                $('#edit-address-street-number').val(data.streetNumber);
                $('#edit-address-street-name').val(data.streetName);
                $('#edit-address-city').val(data.city);
                $('#edit-address-state').val(data.state);
                $('#edit-address-zip').val(data.zip);
                $('#edit-id').val(data.id);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    
    $('#edit-address-button').on('click', function(e) {
        
        e.preventDefault();
        
        var addressData = JSON.stringify({
            firstName: $('#edit-address-first-name').val(),
            lastName: $('#edit-address-last-name').val(),
            streetNumber: $('#edit-address-street-number').val(),
            streetName: $('#edit-address-street-name').val(),
            city: $('#edit-address-city').val(),
            state: $('#edit-address-state').val(),
            zip: $('#edit-address-zip').val(),
            id: $('#edit-id').val()
        });
        
        $.ajax({
            
            url: contextRoot + "/address",
            type: "PUT",
            data: addressData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                
                $('#editAddressModal').modal('hide');
                
                var tableRow = buildAddressRow(data);
                
                $('#address-row-' + data.id).replaceWith( $(tableRow) );
            },
            error: function(data, status) {
               alert("error");
            }
        });
        
        //alert("alert after ajax");
        
    });
    
    $(document).on('click', '.delete-link', function(e) {
        e.preventDefault();
        
        var addressId = $(e.target).data('address-id');
        
        $.ajax({
            type: "DELETE",
            url: contextRoot + "/address/" + addressId,
            success: function(data, status) {
                $('#address-row-' + addressId).remove();
            },
            error: function(data, status) {
                
            }
        });
    });
    function buildAddressRow(data) {
        return "<tr id='address-row-" + data.id + "'>  \n\
                <td><a data-address-id='" + data.id +"' data-toggle='modal' data-target='#showAddressModal'>" + data.firstName + "</a></td>  \n\
                <td> " + data.lastName + "</td>    \n\
                <td> <a data-address-id='" + data.id +"' data-toggle='modal' data-target='#editAddressModal'>Edit</a>  </td>   \n\
                <td> <a data-address-id='" + data.id +"' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";
        
    }
});

