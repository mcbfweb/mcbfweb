<%
	/*==================================================================
	 PayPal Express Checkout Call
	 ===================================================================
	*/
%>
<%@include file="paypalfunctions.jsp" %>
<%

	/*
	'-------------------------------------------
	' The paymentAmount is the total value of 
	' the shopping cart, that was set 
	' earlier in a session variable 
	' by the shopping cart page
	'-------------------------------------------
	*/

	String paymentAmount = (String) session.getAttribute("Payment_Amount");

	/*
	'------------------------------------
	' The currencyCodeType and paymentType 
	' are set to the selections made on the Integration Assistant 
	'------------------------------------
	*/

	String currencyCodeType = "CAD";
	String paymentType = "Sale";

	/*
	'------------------------------------
	' The returnURL is the location where buyers return to when a
	' payment has been succesfully authorized.
	'
	' This is set to the value entered on the Integration Assistant 
	'------------------------------------
	*/

	String returnURL = "http://192.168.0.13:8080/mcbfweb/paypal/pages/confirm.jsp";

	/*
	'------------------------------------
	' The cancelURL is the location buyers are sent to when they hit the
	' cancel button during authorization of payment during the PayPal flow
	'
	' This is set to the value entered on the Integration Assistant 
	'------------------------------------
	*/
	String cancelURL = "http://192.168.0.13:8080/mcbfweb/paypal/pages/cancel.jsp";

	/*
	'------------------------------------
	' Calls the SetExpressCheckout API call
	'
	' The CallShortcutExpressCheckout function is defined in the file PayPalFunctions.asp,
	' it is included at the top of this file.
	'-------------------------------------------------
	*/

	HashMap nvp = CallShortcutExpressCheckout (paymentAmount, currencyCodeType, paymentType, returnURL, cancelURL, session);
	String strAck = nvp.get("ACK").toString();
	if(strAck !=null && strAck.equalsIgnoreCase("Success"))
	{
		//' Redirect to paypal.com
		RedirectURL( nvp.get("TOKEN").toString(), response);
	}
	else
	{  
		// Display a user friendly Error on the page using any of the following error information returned by PayPal
		
		String ErrorCode = nvp.get("L_ERRORCODE0").toString();
		String ErrorShortMsg = nvp.get("L_SHORTMESSAGE0").toString();
		String ErrorLongMsg = nvp.get("L_LONGMESSAGE0").toString();
		String ErrorSeverityCode = nvp.get("L_SEVERITYCODE0").toString();
		System.out.println(ErrorLongMsg);
	}
%>