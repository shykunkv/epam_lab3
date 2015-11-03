<html 	xsl:version="1.0"
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		lang="en">
		<head>
			<title>Candy</title>
		</head>

		<body>
			<table border="1">
				<tr>
					<th rowspan="2">Prod</th>
					<th rowspan="2">Name</th>
					<th rowspan="2">Energy</th>
					<th rowspan="2">Type</th>
					<th colspan="5">Ingredients</th>
					<th colspan="3">Value</th>
				</tr>
				<tr>
					<th>Water</th>
					<th>Sugar</th>
					<th>Fructose</th>
					<th>ChockType</th>
					<th>Vanillin</th>
					<th>Proteins</th>
					<th>Fats</th>
					<th>Carbohydrates</th>
				</tr>

				<xsl:for-each select="Candy/candy">
					<tr>
						<td>
							<xsl:value-of select="@production"/>
						</td>
						<td>
							<xsl:value-of select="name"/>
						</td>
						<td>
							<xsl:value-of select="energy"/>
						</td>
						<td>
							<xsl:value-of select="type"/>
						</td>
						<td>
							<xsl:value-of select="ingredients/water"/>
						</td>
						<td>
							<xsl:value-of select="ingredients/sugar"/>
						</td>
						<td>
							<xsl:value-of select="ingredients/fructose"/>
						</td>
						<td>
							<xsl:value-of select="ingredients/chocType"/>
						</td>
						<td>
							<xsl:value-of select="ingredients/vanillin"/>
						</td>
						<td>
							<xsl:value-of select="value/fats"/>
						</td>
						<td>
							<xsl:value-of select="value/proteins"/>
						</td>
						<td>
							<xsl:value-of select="value/carbohydrates"/>
						</td>
					</tr>
				</xsl:for-each>
			</table>
		</body>
</html>