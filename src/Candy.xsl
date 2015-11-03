<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml"/>

	<xsl:template match="/">
        <Type>
		<xsl:apply-templates />
	</Type>
    </xsl:template>

    <xsl:template match="candy">
	<candy production="{@production}">
	    <xsl:apply-templates />
	</candy>
    </xsl:template>

    <xsl:template match="name">
        <name>
	    <xsl:value-of select="." />
	</name>
    </xsl:template>

    <xsl:template match="energy">
        <energy>
	    <xsl:value-of select="." />
	</energy>
    </xsl:template>

    <xsl:template match="type">
        <type>
	    <xsl:value-of select="." />
	</type>
    </xsl:template>

    <xsl:template match="ingredients">
        <ingredients>
	    <xsl:apply-templates />
	</ingredients>
    </xsl:template>

    <xsl:template match="water">
        <water>
	    <xsl:value-of select="." />
	</water>
    </xsl:template>

    <xsl:template match="sugar">
   		<sugar>
		<xsl:value-of select="." />
	</sugar>
    </xsl:template>

    <xsl:template match="fructose">
        <fructose>
	    <xsl:value-of select="." />
	</fructose>
    </xsl:template>

    <xsl:template match="chocType">
        <chocType>
	    <xsl:value-of select="." />
	</chocType>
    </xsl:template>

    <xsl:template match="vanillin">
        <vanillin>
	    <xsl:value-of select="." />
	</vanillin>
    </xsl:template>

    <xsl:template match="value">
        <value>
	    <xsl:apply-templates />
	</value>
    </xsl:template>

    <xsl:template match="ptoreins">
        <proteins>
	    <xsl:value-of select="." />
	</proteins>
    </xsl:template>

    <xsl:template match="fats">
        <fats>
	    <xsl:value-of select="." />
	</fats>
    </xsl:template>

    <xsl:template match="carbohydrates">
        <carbohydrates>
	    <xsl:value-of select="." />
	</carbohydrates>
    </xsl:template>
</xsl:stylesheet>