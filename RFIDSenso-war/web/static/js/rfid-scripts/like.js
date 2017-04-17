$(document).ready(function () {
    var eventDetail = function () {

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
    $(document).on('keyup', '#tag', function (e) {
        if (e.which === 13) {
            
            var userImage = 'http://graph.facebook.com/';
            
            _tagId = $('#tag').val();
            postToFB([{name: 'tagId', value: _tagId}]);

            _tagId = '';
            setTimeout(function () {

                userImage += _objUser.id + '/picture?type=large';
                $('.container-like-thnx #mainArea .like-us img').attr('src', userImage);
                $('.container-like-thnx #mainArea .like-us img').before('<h1><strong>Gracias: </strong>'+ _objUser.name +'</h1>');
                $('.container-like-thnx #mainArea .like-us img').after('<h1>Por darnos like.</h1>');
                
                var app_user='/'+ _objUser.id +'/og.likes';
                var app_method = 'POST';
                var app_objectToLike = $('#app_objUrl').val();
                var app_privacy = { 'value': $('#app_privacy').val() };
                
                //function postLike() {
                console.log('postLike()' );
                //reference: https://developers.facebook.com/docs/reference/opengraph/action-type/og.likes
                FB.api(
                    app_user,
                    app_method,
                    {
                        "object": app_objectToLike,
                        "privacy": app_privacy,
                        "no_feed_story": false,
                        "fb:explicitly_shared": true,
                        "access_token": _objUser.token,
                        "image": 'http://senso-lab.com/static/img/senso_lab_fb.png'
                        //"message": 'Message Uploaded using JS. Powered by SensoLab' // Optional
                        //"place": '447480532052318', // Optional
                        //"tags": '10202283258681721', '10152985972543793' // Optional
                    },
                    function (response) { 
                        if (!response) {
                            console.log('Error ocurred.');

                        } else if (response.error) {
                            console.log('Error: ' + response.error.message);

                        } else {
                            console.log('Success. LikeId: ' + response.id);
                            //FadeOut on '.container-like'
                            $('.container-like').fadeOut(400);
                            $('.container-like').removeClass('visible').addClass('hidde');
                            //FadeInd '.container-like-thnx'
                            
                            //$('.like-us p').html('Gracias por darnos Like ' + _objUser.name );
                            $('.container-like-thnx').fadeIn(400);
                            $('.container-like-thnx').removeClass('hidde').addClass('visible');

                            setTimeout(function () {
                                //FadeOut '.container-like-thnx'
                                $('.container-like-thnx').fadeOut(400);
                                $('.container-like-thnx').removeClass('visible').addClass('hidde');
                                $('.container-like-thnx #mainArea .like-us h1').remove();
                                $('.container-like-thnx #mainArea .like-us img').removeAttr('src');
                                $('#tag').val('');
                                
                            }, 3000);
                            setTimeout(function () {
                                //FadeIn '.container-like'
                                $(".container-like").fadeIn(400);
                                $('.container-like-thnx').removeClass('hidde').addClass('visible');

                            }, 3000);
                        }

                    }
                );
                //}                            

            }, 1500);
        } else {
            return false;

        }
    });
    
});