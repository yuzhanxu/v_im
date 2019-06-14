class StoreUtils {

  static setJson(key,json){
    console.log("JSON.stringify(json)",JSON.stringify(json));
    sessionStorage.setItem(key,JSON.stringify(json));
  }

  static getJson(key){
    if(!key) {
      return null;
    }
    return JSON.parse(sessionStorage.getItem(key));
  }

  static setValue(key,value){
    sessionStorage.setItem(key,value)
  }

  static getValue(){
    return sessionStorage.getItem(key);
  }

  static setToken(token){
    return StoreUtils.setJson("token",token);
  }

  static getToken(){
    return StoreUtils.getJson("token");
  }

  static getAccessToken(){
    return StoreUtils.getJson("token").access_token;
  }

  static setUser(user){
    return StoreUtils.setJson("user",user);
  }

  static getUser(){
    return StoreUtils.getJson("user");
  }

  static setChatGroupList(chatList){
    StoreUtils.getJson("chatGroupList",chatList);
  }

  static getChatGroupList(){
    return StoreUtils.getJson("chatGroupList");
  }

  static setFriendList(friendList){
     StoreUtils.setJson("friendList",friendList);
  }

  static getFriendList(){
    return StoreUtils.getJson("friendList");
  }
}

export default StoreUtils;
