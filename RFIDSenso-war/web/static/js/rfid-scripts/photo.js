$(document).ready( function() {
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
        //$('#event_detail').html('');
        console.log(obj);
        return obj;
    };
    
    _eventDetail = eventDetail();

    $('#tag').focus();
    sayCheese.on('start', function() {
        
        
        $(document).on('keyup', '#tag', function(e){
            if (e.which === 13) {
                _tagId = $('#tag').val();
                
                $("#cam").hide();
                login.show();
                login.animate({top: -390}); 
                
                e.preventDefault();
                
                postToFB([{name: 'tagId', value: _tagId}]);

                $('.message-success').hide();

                setTimeout(function() {
                    var width = 640, height = 480;                   

                    sayCheese.takeSnapshot(width, height);
                }, 8000);
                
            } else {
                return false;

            }
        });
        
//        $(window).on('keyup', function(e) {
//            login.show();
//            login.animate({top: -390}); 
//            //login.css('top', _top + 'px');
//
//            if (e.which === 13) {
//                //$('#tagId').val(_tagId);
//                e.preventDefault();
//                
//                postToFB([{name: 'tagId', value: _tagId}]);
//                //savePhoto([{name: 'tagId', value: _tagId}]);
//                
//                $('.message-success').hide();
//                $("#cam").hide();
//                
//                //<!-- countdown -->
//                //$('#mainArea').hide();
//                /*$(".overlay_timer").fadeIn('fast');
//                $(".overlay_timer_2").fadeIn('fast');
//                $(".overlay_timer_3").fadeIn('fast');
//                $(".overlay_timer_4").fadeIn('fast');
//
//                setTimeout(function() {
//                    $(".overlay_timer").fadeOut('slow');
//                }, 4000);
//                setTimeout(function() {
//                    $(".overlay_timer_4").fadeOut('fast');
//                }, 1000);
//                setTimeout(function() {
//                    $(".overlay_timer_3").fadeOut('fast');
//                }, 2000);
//                setTimeout(function() {
//                    $(".overlay_timer_2").fadeOut('fast');
//                    //$('#camera-test').show();
//                    //$('#camera-test video').show();
//                }, 3000);*/
//                
//                setTimeout(function() {
//                    var width = 640, height = 480;                   
//                    
//                    sayCheese.takeSnapshot(width, height);
//                }, 8000);
//
//            } else {
//                console.log(e);
//                _tagId = _tagId + e.key;
//
//            }
//        });
    });

    sayCheese.on('error', function(error) {
        // handle errors, such as when a user denies the request to use the webcam,
        // or when the getUserMedia API isn't supported
        console.log(error);
    });

    sayCheese.on('snapshot', function(snapshot) {
        // do something with a snapshot canvas element, when taken
        
        var img = document.createElement('img');
        $(img).attr('class', 'watermark');
        $(img).on('load', function() {
            applyWatermark(img);
            $(img).unbind('load');
            photos.prepend(img);
            try {
                PostImageToFacebook(img.src);
                $('.message-success').show();
                return false;
            } catch (e) {
                console.log('Error: ' + e.toSource());
            }
        });
        //console.log('applyWatermark(img)');
        img.src = snapshot.toDataURL('image/png');
        //applyWatermark(img);
        
        //post image to FB user's wall
        /*try {
            PostImageToFacebook(img.src);
        } catch (e) {
            console.log('Error: ' + e.toSource());
        }*/
        _tagId = '';
        $('#tag').val('');
        $('.message-success').hide();
        login.animate({top: 190});
        login.hide();
        $("#cam").show();
        //send message  'The photo has been published in user's wall'
        //message duration 3 seconds
        
    });

    //sayCheese.start();


    
});

function PostImageToFacebook(imageData) {
    /*var canvas = document.getElementById("c");
    var imageData = canvas.toDataURL("image/png");*/
    
    try {
        blob = dataURItoBlob(imageData);
    } catch (e) {
        console.log(e);
    }
    
    var fd = new FormData();
    fd.append("access_token", _objUser.token);
    fd.append("source", blob);
    //fd.append("message", "Message upload using SensoConnect");
    
    try {
        $.ajax({
            url: 'https://graph.facebook.com/' + _objUser.id +'/photos?access_token=' + _objUser.token,
            type: "POST",
            data: fd,
            processData: false,
            contentType: false,
            cache: false,
            success: function(data) {
                console.log("success " + data.post_id);
                //data.post_id
                
            },
            error: function(shr, status, data) {
                console.log("error " + data + " Status " + shr.status);
            },
            complete: function() {
                $('#tag').val('');
                $('#tag').focus();
            }
        });

    } catch (e) {
        console.log(e);
    }
}

function dataURItoBlob(dataURI) {
    var byteString = atob(dataURI.split(',')[1]);
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], {type: 'image/png'});
}