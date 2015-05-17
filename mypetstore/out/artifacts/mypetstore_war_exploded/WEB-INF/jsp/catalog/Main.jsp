<%--
  Created by IntelliJ IDEA.
  User: jinyejun
  Date: 5/10/15
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Welcome">
  <div id="WelcomeContent">
    Welcome to MyPetStore!
  </div>
</div>
<div id="tip" style="display: none; position: absolute; z-index: 1;width: 300px;height: auto !important;height:100px;min-height: 50px; background-color: lightyellow" ></div>
<div id="Main">
  <div id="Sidebar">
    <div id="SidebarContent">

      <a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
      <br/> Saltwater, Freshwater <br/>
      <a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
      <br /> Various Breeds <br />
      <a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
      <br /> Various Breeds, Exotic Varieties <br />
      <a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
      <br /> Lizards, Turtles, Snakes <br />
      <a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
      <br /> Exotic Varieties
    </div>

    <script language="javascript">
      var xmlHttpRequest;
      var currentCategory;
      function createXMLHttpRequest(){
        if(window.XMLHttpRequest){
          xmlHttpRequest = new XMLHttpRequest();
        }else if(window.ActiveXObject){
          xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }else{
          xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
      }

      function sendRequeset(url){
        createXMLHttpRequest();
        xmlHttpRequest.open("GET", url, true);
        xmlHttpRequest.onreadystatechange = processResponse;
        xmlHttpRequest.send(null);
      }


      var divtip = document.getElementById("tip");
      var x,y;

      function processResponse(){
        if(xmlHttpRequest.readyState == 4){
          if(xmlHttpRequest.status == 200){
            var products = xmlHttpRequest.responseText;
            divtip.style.left = x;
            divtip.style.top = y;
            divtip.innerHTML = "products:"+products;
            divtip.style.display = "block";
          }
        }
      }


      function showTip(event, category){
        event= event || window.event;
        x = event.clientX;
        y = event.clientY;
        sendRequeset("getCategoryInfo?category="+category);
      }

      function hiddenTip(){
        divtip.innerHTML="";
        divtip.style.display="none";
      }

    </script>
  </div>

  <div id="MainImage">
    <div id="MainImageContent">
      <map name="estoremap">
        <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" shape="rect" name="BIRDS" onmouseover="showTip(event,'BIRDS')" onmouseout="hiddenTip()"/>
        <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" shape="rect" name="FISH" onmouseover="showTip(event, 'FISH')" onmouseout="hiddenTip()"/>
        <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" shape="rect"  name="DOGS" onmouseover="showTip(event, 'DOGS')" onmouseout="hiddenTip()"/>
        <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" shape="rect" name="REPTILES" onmouseover="showTip(event, 'REPTILES')" onmouseout="hiddenTip()"/>
        <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" shape="rect" name="CATS" onmouseover="showTip(event, 'CATS')" onmouseout="hiddenTip()"/>
        <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" shape="rect" name="BIRDS" onmouseover="showTip(event, 'BIRDS')" onmouseout="hiddenTip()"/>
      </map>
      <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
    </div>
  </div>
  <div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
