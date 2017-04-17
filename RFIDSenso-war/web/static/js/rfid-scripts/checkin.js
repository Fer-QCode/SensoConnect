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

    //<!-- For Demo use Only - Remove
    var place = 'Senso Lab',
		lat = '19.309177791637',
		lon = '-99.165527699307',
		page_id = '447480532052318';
                
	//Remove or Modify this code -->
    
    $(document).on('keyup', '#tag', function (e) {
        if (e.which === 13) {
            var userImage = 'http://graph.facebook.com/';
            
            _tagId = $('#tag').val();
            postToFB([{name: 'tagId', value: _tagId}]);

            _tagId = '';
            
            setTimeout(function () {
                $('.container-like-thnx #mainArea .check-in img').before('<h1><strong>Bienvenido: </strong>'+ _objUser.name +'</h1>');
                $('.container-like-thnx #mainArea .check-in img').after('<h1>Disfruta tu visita</h1>');
                
                findPlaceEvent(place, userImage);
                

            },3000);
        } else {
            return false;

        }
    });
    
});

function findPlaceEvent(place, userImage){
	
	try{
            $.ajax({
                url: "https://graph.facebook.com/v2.2/search?q='"+place+"'&type=place&access_token=" + _objUser.token,
                type: "GET",
                processData: false,
                contentType: false,
                cache: false,
                success: function(data) {
                    _jsonPlace = data.data;

                },
                error: function(shr, status, data) {
                    console.log("error " + data + " Status " + shr.status);
                    _jsonPlace = null;
                },
                complete: function() {
                    $('#tag').val('');
                    $('#tag').focus();
                    
                    userImage += _objUser.id + '/picture?type=large';
                    $('.container-like-thnx #mainArea .check-in img').attr('src', userImage);
                    
                    var objPlace='';
                    var app_user='/'+ _objUser.id +'/feed';
                    var app_method = 'POST';
                    //var app_objectToLike = $('#app_objUrl').val();
                    var app_privacy = { 'value': $('#app_privacy').val() };
                    objPlace = getObjPlace(place);
                    
                    console.log('postCheckIn' );
                    
                    if(objPlace){
                        FB.api(
                            app_user,
                            app_method,
                            { 
                                'place': objPlace.id,
                                'privacy': app_privacy,
                                'access_token': _objUser.token,
                                //'message': 'CheckIn Uploaded using JS. Powered by SensoLab' // Optional
                                //'tags': '', // Optional

                            },
                            function (response) { 
                                if (!response) {
                                    console.log('Error ocurred.');

                                } else if (response.error) {
                                    console.log('Error: ' + response.error.message);

                                } else {
                                    console.log('Success. CheckIn: ' + response.id);
                                    //FadeOut on '.container-like'
                                    $('.container-like').fadeOut(400);
                                    $('.container-like').removeClass('visible').addClass('hidde');
                                    //FadeInd '.container-like-thnx'
                                    $('.check-in img h1').html(_objUser.name);
                                    //$('.check-in p').html('Gracias por darnos Like ' + _objUser.name );
                                    $('.container-like-thnx').fadeIn(400);
                                    $('.container-like-thnx').removeClass('hidde').addClass('visible');

                                    setTimeout(function () {
                                        //FadeOut '.container-like-thnx'
                                        $('.container-like-thnx').fadeOut(400);
                                        $('.container-like-thnx').removeClass('visible').addClass('hidde');
                                        $('.container-like-thnx #mainArea .check-in h1').remove();
                                        $('.container-like-thnx #mainArea .check-in img').removeAttr('src');
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
                    }
                }
            });
	} catch (e) {
            console.log(e);
	}

	
}

function getObjPlace(place){
    var _placeDetail = false;
    var i;
    
    if(_jsonPlace !== null){
        for(i=0; i < _jsonPlace.length; i++){

            if( place === _jsonPlace[i].name){

                _placeDetail = _jsonPlace[i];
                break;
            }
        }
    
    }
    
    return _placeDetail;
}