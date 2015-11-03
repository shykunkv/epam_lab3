<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
	<html>
		<head>
			<title>Candy collection</title>	
		</head>
		<body>
			<table border = "1">
				<tr>
					<th>Name</th>
					<th>Production</th>
				</tr>
				<xsl:for-each select = "collection/candy">
					<tr>
						<td><xsl:value-of select="name"/></td>
						<td><xsl:value-of select="production"/></td>
					</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>
	
	</xsl:template>
</xsl:stylesheet>