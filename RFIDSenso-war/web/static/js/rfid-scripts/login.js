$(function() {
    $('#javax_faces_developmentstage_messages').remove();

    $('#formRfid\\:activate-card').hover( function(){
       $('#formRfid\\:activate-card').removeClass("ui-state-hover"); 
    });

    var eventDetail = function() {

        var obj = $.parseJSON(
                '{ ' +
                ' "app_id": "' + $('#app_id').val() + '", ' +
                ' "app_secret": "' + $('#app_secret').val() + '", ' +
                ' "app_objUrl": "' + $('#app_objUrl').val() + '", ' +
                ' "app_privacy": "' + $('#app_privacy').val() + '", ' +
                ' "app_scopes": "' + $('#app_scopes').val() + '" ' +
                '}'
                );
        $('#event_detail').html('');
        return obj;
    };

    _eventDetail = eventDetail();

    //Inicializa SDK y obtiene el estado de la conexión
    window.fbAsyncInit = function() {
        FB.init({
            appId: _eventDetail.app_id,
            status: true,
            cookie: true,
            xfbml: true,
            version: 'v2.2' //'v2.1'
        });

        FB.getLoginStatus(function(response) {
            statusChangeCallback(response, function() {
            });
        });
    };

    // This is called with the results from from FB.getLoginStatus().
    var statusChangeCallback = function(response, callback) {
        if (response.status === 'connected') {
            getFacebookData();
        } else {
            callback(false);
        }
    };

    // This function is called when someone finishes with the Login
    // Button.  See the onlogin handler attached to it in the sample
    // code below.
    var checkLoginState = function(callback) {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response, function(data) {
                callback(data);
            });
        });
    };

    var getFacebookData = function() {
        FB.api('/me', function(response) {
            fbUserObj = response;
            $('.container-login #facebook-session strong').text(response.name);
            $('.container-login #formLoginFB').hide();
            $('.container-login #formRfid').show();
            $('.container-login #facebook-session img').attr('src', 'http://graph.facebook.com/' + response.id + '/picture?type=large');
            $('.container-login #formRfid input[name="formRfid:id-card-fb"]').attr('id', 'formRfid_id-card-fb').attr('placeholder', 'Escanea tu tarjeta');
            $('#formRfid\\:activate-card').removeAttr('class').attr('class', 'btn btn-success');
            $('.login .titulo').removeAttr('style').css({'margin-top': '80px', 'margin-bottom': '65px'});
            $('#welcome-title').show();
        });
    };
    
    var facebookLogin = function() {
        checkLoginState(function(response) {
            if (!response) {
                FB.login(function(response) {
                    if (response.status === 'connected')
                        getFacebookData();
                        gtAccessToken();
                }, {
                    scope: _eventDetail.app_scopes
                });
            }
        });
    };

    var facebookLogout = function() {
        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                FB.logout(function(response) {
                    //$('.container-login #formRfid').hide();
                    clearFormLogged();
                    $('.container-login #formRfidLogged').hide();
                    $('.container-login #formRfid').hide();
                    $('.login .titulo').removeAttr('style').css({'margin-top': '100px', 'margin-bottom': '100px'});
                    $('.container-login #formLoginFB').show();
                    $('#welcome-title').hide();
                });
            }
        });
    };

    var usrAccesToken;
    var gtAccessToken = function() {

        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                usrAccesToken = response.authResponse.accessToken;
                $("#formRfid\\:user-token").val(usrAccesToken);

                var usrTokenLong = '';
                //get Tkoen Long
                $.ajax({
                    type: 'GET',
                    url: 'https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token&client_id=' + _eventDetail.app_id + '&client_secret=' + _eventDetail.app_secret + '&fb_exchange_token=' + usrAccesToken,
                    success: function(result) {
                        var arrResult = result.split('&');
                        usrTokenLong = arrResult[0].split('=');
                        usrTokenLong = usrTokenLong[1];
                        $("#formRfid\\:user-token-long").val(usrTokenLong);
                        ajaxSuccess = true;
                    },
                    error: function(msg) {
                        console.log('Error:' + msg);
                        ajaxSuccess = false;
                    }
                });
            }
        });

    };

    $(document).on('click', '.facebook', function(e) {
        e.preventDefault();

        facebookLogin();
    });

    $(document).on('click', '#logout', function(e) {
        e.preventDefault();

        facebookLogout();
    });
    
    //var _tagId = '';
    /*$(document).on('focus', '#formRfid_id-card-fb', function(){        
        _tagId = '';
        $('#formRfid_id-card-fb').val('');
        $('#formRfid_id-card-fb').keyup( function(e) {
            e.preventDefault();
            if (e.which === 13) {
                $('#tag_Id').val(_tagId);
                _tagId = '';
                $('#formRfid_id-card-fb').val( $('#tag_Id').val() );
            } else {
                _tagId = _tagId + e.key;

            }

        });
        
    });*/

});

function beforeSubmit() {
    //$('#formRfid_id-card-fb').removeAttr('enabled').attr('disabled');
    //$('#formRfid_id-card-fb').attr('disabled');

    $("#formRfid\\:user-Id").val(fbUserObj.id);
    $("#formRfid\\:user-fname").val(fbUserObj.first_name);
    $("#formRfid\\:user-lname").val(fbUserObj.last_name);
    $("#formRfid\\:user-gender").val(fbUserObj.gender);
    $("#formRfid\\:user-fbname").val(fbUserObj.name);

}

function registroExitoso() {
    console.log('registro exitoso');
    clearFormLogged();

    $('#formLoginFB').hide();
    $('#formRfidLogged').show();
    $('.container-login #facebook-session').css('margin','0 auto 70px');
    $('.container-login #facebook-session img').attr('src', 'http://graph.facebook.com/' + fbUserObj.id + '/picture?type=large');
}

function registroFallido() {
    console.log('registro fallido');
    clearFormLogged();
    
    //$('#formRfid_id-card-fb').removeAttr('disabled').attr('enabled');
    $('#formRfid').hide();
    $('#formLoginFB').show();
}

function clearFormLogged() {
    $('#facebook-session img').removeAttr('src');
    $('#formRfid\\:id-card-fb').val('');
    $("#formRfid\\:user-Id").val('');
    $("#formRfid\\:user-fname").val('');
    $("#formRfid\\:user-lname").val('');
    $("#formRfid\\:user-gender").val('');
    $("#formRfid\\:user-fbname").val('');
    $("#formRfid\\:user-token").val('');
    $("#formRfid\\:user-token-long").val('');
}