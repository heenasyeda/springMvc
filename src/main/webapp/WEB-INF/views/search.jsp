<%@ page language="java" %>
<%@ page import="java.net.URLEncoder" %>

<%
  String filter = request.getParameter("filter");
  String query = request.getParameter("query");
  
  // Perform search processing based on the selected filter and query
  
  // Redirect to a search results page with the filter and query parameters
  String encodedFilter = URLEncoder.encode(filter, "UTF-8");
  String encodedQuery = URLEncoder.encode(query, "UTF-8");
  response.sendRedirect("search-results.jsp?filter=" + encodedFilter + "&query=" + encodedQuery);
%>
