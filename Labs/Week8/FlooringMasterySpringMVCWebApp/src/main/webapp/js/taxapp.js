/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
$('#tax-create-submit').on('click', function(e) {
        
        e.preventDefault();
        
        var taxData = JSON.stringify({
            state: $('#state-input').val(),
            taxRate: $('#tax-rate-input').val()
            
        });
        
        $.ajax({
            
            url: contextRoot + "/admin/tax",
            type: "POST",
            data: taxData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                alert("success");
                
                var tableRow = buildTaxRow(data);
                
                $('#tax-table').append($(tableRow));
            },
            error: function (data, status) {
                var errors = data.responseJSON.errors;
                console.log(errors);
                $.each(errors, function (index, validationError) {
                $('#add-tax-validation-errors').append(validationError.fieldName + ": " + validationError.message).append("<br/>");
            });
            
            }
        });
        
        //alert("alert after ajax");
    });
    
    $('#editTaxModal').on('show.bs.modal', function(e) {
        var link = $(e.relatedTarget);
        
        var taxId = link.data('tax-state');
        
        $.ajax({ 
        
            url: contextRoot + "/admin/tax/" + taxId,
            type: 'GET',
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success : function(data, status) {
                $('#edit-tax-state').val(data.state);
                $('#edit-tax-rate').val(data.taxRate);
            },
            error: function(data, status) {
                
            }
        
        });
    });
    
    $('#edit-tax-button').on('click', function(e) {
        
        e.preventDefault();
        
        var taxData = JSON.stringify({
            state: $('#edit-tax-state').val(),
            taxRate: $('#edit-tax-rate').val()
        });
        
        $.ajax({
            
            url: contextRoot + "/admin/tax",
            type: "PUT",
            data: taxData,
            dataType: 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function(data, status) {
                
                $('#editTaxModal').modal('hide');
                
                var tableRow = buildTaxRow(data);
                
                $('#tax-row-' + data.state).replaceWith( $(tableRow) );
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
    
    $(document).on('click', '.delete-link', function(e) {
        e.preventDefault();
        
        var taxId = $(e.target).data('tax-state');
        
        $.ajax({
            type: "DELETE",
            url: contextRoot + "/admin/tax/" + taxId,
            success: function(data, status) {
                $('#tax-row-' + taxId).remove();
            },
            error: function(data, status) {
                
            }
        });
    });
    function buildTaxRow(data) {
                return "<tr id='tax-row-" + data.state + "'>  \n\
                <td>" + data.state + "</td>    \n\
                <td>" + data.taxRate + "</td>    \n\
                <td> <a data-tax-state='" + data.state +"' data-toggle='modal' data-target='#editTaxModal'>Edit</a>  </td>   \n\
                <td> <a data-tax-state='" + data.state +"' class='delete-link'>Delete</a>  </td>   \n\
                </tr>  ";
    }
});    
