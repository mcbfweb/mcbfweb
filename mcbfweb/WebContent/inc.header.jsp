<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<html>
<head>
<meta charset="utf-8">
<script src="http://maps.google.com/maps/api/js?sensor=true"
	type="text/javascript"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<sjm:head compressed='false' jqueryui="true" jquerytheme="ui-lightness" />
<!-- <link rel="stylesheet"
	href="http://code.jquery.com/mobile/git/jquery.mobile-git.css"> -->
<script src="../js/jquery.ui.map.full.min.js" type="text/javascript"></script>

<title>MCM</title>

<script>
	var xmlHttp;

	function filterByType(str, str2) {
		//alert(str + "_" + str2);
		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			alert("Microsoft");
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp == null) {
			alert("Browser does not support XMLHTTP Request")
			return;
		}
		if (str2 == "bizType") {
			url = "../sortByType.jsp";
			url += "?bizType=" + str;	
			
			//alert(url);
			xmlHttp.onreadystatechange = filterTypeChange;
		}
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
		 
	}
	function filterTypeChange() {
		//alert("ready State = "+ xmlHttp.readyState);
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			var obj = document.getElementById("filterList");
			var inner = xmlHttp.responseText;
			//alert("Inner - "+  inner);
			//select_innerHTML(obj, inner);
			$("#filterList").append(inner);
		}
	}

	function showChange(str, str2) {
		//alert(str + "_" + str2);
		var url = "";
		var e;

		if (typeof XMLHttpRequest != "undefined") {
			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			alert("Microsoft");
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (xmlHttp == null) {
			alert("Browser does not support XMLHTTP Request")
			return;
		}

		if (str2 == "bizGroup") {
			url = "../bizType.jsp";
			e = document.getElementById("bizGroup");
			bizGroup = e.options[e.selectedIndex].value;
			url += "?bizGroup=" + str;
			
			xmlHttp.onreadystatechange = bizGroupChange;
		}
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function bizGroupChange() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {

			//document.getElementById("district0_en").innerHTML=xmlHttp.responseText; 
			var obj = document.getElementById("bizType");
			var inner = xmlHttp.responseText;
			select_innerHTML(obj, inner);

		}
	}
	///this whole method as needed as cannot add options to select in IE 

	/******
	 * select_innerHTML - corrige o bug do InnerHTML em selects no IE
	 * Veja o problema em: http://support.microsoft.com/default.aspx?scid=kb;en-us;276228
	 * Versão: 2.1 - 04/09/2007
	 * Autor: Micox - Náiron José C. Guimarães - micoxjcg@yahoo.com.br
	 * @objeto(tipo HTMLobject): o select a ser alterado
	 * @innerHTML(tipo string): o novo valor do innerHTML
	 *******/
	function select_innerHTML(objeto, innerHTML) {

		objeto.innerHTML = ""
		var selTemp = document.createElement("myselect")
		var opt;
		selTemp.id = "myselect1"
		document.body.appendChild(selTemp)
		selTemp = document.getElementById("myselect1")
		selTemp.style.display = "none"
		if (innerHTML.indexOf("<option") < 0) {
			innerHTML = "<option>" + innerHTML + "</option>"
		}
		innerHTML = innerHTML.replace(/<option/g, "<span").replace(/<\/option/g, "</span")
		selTemp.innerHTML = innerHTML

		for (var i = 0; i < selTemp.childNodes.length; i++) {
			var spantemp = selTemp.childNodes[i];

			if (spantemp.tagName) {
				opt = document.createElement("OPTION")

				if (document.all) { //IE
					objeto.add(opt)
				} else {
					objeto.appendChild(opt)
				}

				//getting attributes
				for (var j = 0; j < spantemp.attributes.length; j++) {
					var attrName = spantemp.attributes[j].nodeName;
					var attrVal = spantemp.attributes[j].nodeValue;
					if (attrVal) {
						try {
							opt.setAttribute(attrName, attrVal);
							opt.setAttributeNode(spantemp.attributes[j].cloneNode(true));
						} catch (e) {
						}
					}
				}
				//getting styles
				if (spantemp.style) {
					for ( var y in spantemp.style) {
						try {
							opt.style[y] = spantemp.style[y];
						} catch (e) {
						}
					}
				}
				//value and text
				opt.value = spantemp.getAttribute("value")
				opt.text = spantemp.innerHTML
				//IE
				opt.selected = spantemp.getAttribute('selected');
				opt.className = spantemp.className;
			}
		}
		document.body.removeChild(selTemp)
		selTemp = null
	}
</script>


</head>
<body>