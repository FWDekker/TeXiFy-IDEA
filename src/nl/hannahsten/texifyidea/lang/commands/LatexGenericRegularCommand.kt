package nl.hannahsten.texifyidea.lang.commands

import nl.hannahsten.texifyidea.lang.LatexPackage
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.AMSMATH
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.BIBLATEX
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.CLEVEREF
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.COLOR
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.CSQUOTES
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.FONTENC
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.GLOSSARIES
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.GRAPHICX
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.MATHTOOLS
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.NTHEOREM
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.TEXTCOMP
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.ULEM
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.VARIOREF
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.XCOLOR

/**
 * @author Hannah Schellekens
 */
enum class LatexGenericRegularCommand(
    override val command: String,
    override vararg val arguments: Argument = emptyArray(),
    override val dependency: LatexPackage = LatexPackage.DEFAULT,
    override val display: String? = null,
    override val isMathMode: Boolean = false,
    val collapse: Boolean = false
) : LatexCommand {

    ADDTOCOUNTER("addtocounter", "countername".asRequired(), "value".asRequired()),
    A_RING("aa", display = "å"),
    CAPITAL_A_RING("AA", display = "Å"),
    ADDBIBRESOURCE("addbibresource", RequiredFileArgument("bibliographyfile", true, false, "bib"), dependency = BIBLATEX),
    AE("ae", display = "æ"),
    CAPITAL_AE("AE", display = "Æ"),
    APPENDIX("appendix"),
    AUTHOR("author", "name".asRequired(Argument.Type.TEXT)),
    AUTOREF("autoref", "label".asRequired(Argument.Type.LABEL), dependency = LatexPackage.HYPERREF),
    AUTOREF_CAPITAL("Autoref", "label".asRequired(Argument.Type.LABEL), dependency = LatexPackage.HYPERREF),
    BEGIN("begin", "environment".asRequired()),
    END("end", "environment".asRequired()),
    ENSUREMATH("ensuremath", "text".asRequired()),
    BASELINESKIP("baselineskip"),
    BASELINESTRETCH("baselinestretch"),
    BF("bf"),
    BFSERIES("bfseries"),
    BIBITEM("bibitem", "label".asOptional(), "citekey".asRequired()),
    BIBLIOGRAPHYSTYLE("bibliographystyle", "style".asRequired(Argument.Type.BIBLIOGRAPHY_STYLE)),
    BIBLIOGRAPHY("bibliography", RequiredFileArgument("bibliographyfile", true, true, "bib")),
    BIGSKIP("bigskip"),
    BLENDCOLORS("blendcolors", "mix expr".asRequired(), dependency = XCOLOR),
    BLENDCOLORS_STAR("blendcolors*", "mix expr".asRequired(), dependency = XCOLOR),
    BOLDMATH("boldmath"),
    BOXFRAME("boxframe", "width".asRequired(), "height".asRequired(), "depth".asRequired(), dependency = XCOLOR),
    CAPTION("caption", "shorttext".asOptional(), "text".asRequired(Argument.Type.TEXT)),
    CAPTIONOF("captionof", "float type".asRequired(), "list entry".asOptional(), "heading".asRequired(Argument.Type.TEXT)),
    CHAPTER("chapter", "shorttitle".asOptional(), "title".asRequired(Argument.Type.TEXT)),
    CHAPTER_STAR("chapter*", "title".asRequired(Argument.Type.TEXT)),
    CITE("cite", "extratext".asOptional(), "keys".asRequired()),
    CLEARDOUBLEPAGE("cleardoublepage"),
    CLEARPAGE("clearpage"),
    COLOR_CMD("color", "color".asRequired(), dependency = COLOR),
    COLOR2("color", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    COLORBOX("colorbox", "color".asRequired(), "text".asRequired(), dependency = COLOR),
    COLORBOX2("colorbox", "model-list".asOptional(), "spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    COLORMASK("colormask", dependency = XCOLOR),
    COLORSERIESCYCLE("colorseriescycle", dependency = XCOLOR),
    COLUMNSEP("columnsep "),
    COLUMNWIDTH("columnwidth"),
    CONTENTSLINE("contentsline", "type".asRequired(), "text".asRequired(Argument.Type.TEXT), "page".asRequired()),
    CONTENTSNAME("contentsname", "name".asRequired()),
    CONVERTCOLORSPEC("convertcolorspec", "model".asRequired(), "spec".asRequired(), "target model".asRequired(), "cmd".asRequired(), dependency = XCOLOR),
    TEXT_DAGGER("dag", display = "†"),
    TEXT_DOUBLE_DAGGER("ddag", display = "‡"),
    DATE("date", "text".asRequired(Argument.Type.TEXT)),
    DECLARE_MATH_OPERATOR("DeclareMathOperator", "command".asRequired(), "operator".asRequired(Argument.Type.TEXT), dependency = AMSMATH),
    DEF("def"),
    DOCUMENTCLASS("documentclass", "options".asOptional(), RequiredFileArgument("class", true, false, "cls")),
    DOLLAR_SIGN("$", display = "$"),
    DOTFILL("dotfill"),
    EM("em"),
    EMPH("emph", "text".asRequired(Argument.Type.TEXT)),
    ENLARGETHISPAGE("enlargethispage", "size".asRequired()),
    ENLARGETHISPAGE_STAR("enlargethispage*", "size".asRequired()),
    ENQUOTE("enquote", dependency = CSQUOTES),
    ENQUOTE_STAR("enquote*", dependency = CSQUOTES),
    EQREF("eqref", "eqLabel".asRequired(Argument.Type.LABEL), dependency = AMSMATH),
    EVENSIDEMARGIN("evensidemargin"),
    EXTERNALDOCUMENT("externaldocument", "prefix".asOptional(), RequiredFileArgument("file", false, false, "tex")),
    EXTRACTCOLORSPEC("extractcolorspec", "color".asRequired(), "cmd".asRequired(), dependency = XCOLOR),
    EXTRACTCOLORSPECS("extractcolorspecs", "color".asRequired(), "model-cmd".asRequired(), "color-cmd".asRequired(), dependency = XCOLOR),
    FAMILY("family"),
    FBOX("fbox", "text".asRequired(Argument.Type.TEXT)),
    FCOLORBOX("fcolorbox", "frame color".asRequired(), "background color".asRequired(), "text".asRequired(), dependency = COLOR),
    FCOLORBOX2("fcolorbox", "model-list".asOptional(), "frame spec-list".asRequired(), "background spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    FCOLORBOX3("fcolorbox", "frame model-list".asOptional(), "frame spec-list".asRequired(), "background model-list".asOptional(), "background spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    FCOLORBOX4("fcolorbox", "frame color".asRequired(), "background model-list".asOptional(), "background spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    FIGURENAME("figurename", "name".asRequired(Argument.Type.TEXT)),
    FLQ("flq", display = "‹"),
    FLQQ("flqq", display = "«"),
    FLUSHBOTTOM("flushbottom"),
    FLUSHLEFT("flushleft"),
    FLUSHRIGHT("flushright"),
    FONTENCODING("fontencoding", "enc".asRequired()),
    FONTFAMILY("fontfamily", "family".asRequired()),
    FONTSERIES("fontseries", "series".asRequired()),
    FONTSHAPE("fontshape", "shape".asRequired()),
    FONTSIZE("fontsize", "size".asRequired(), "skip".asRequired()),
    FOOTNOTESIZE("footnotesize"),
    FOOTNOTETEXT("footnotetext", "number".asOptional(), "text".asRequired(Argument.Type.TEXT)),
    FOOTNOTE("footnote", "number".asOptional(), "text".asRequired(Argument.Type.TEXT)),
    FOOTNOTEMARK("footnotemark"),
    FRAMEBOX("framebox", "width".asOptional(), "pos".asOptional(), "text".asOptional(Argument.Type.TEXT)),
    FRAME("frame", "text".asRequired(Argument.Type.TEXT)),
    FRQ("frq", display = "›"),
    FRQQ("frqq", display = "»"),
    FULLREF("fullref", "label".asRequired(Argument.Type.LABEL), dependency = LatexPackage.HYPERREF),
    GLOSSARYENTRY("glossaryentry", "text".asRequired(Argument.Type.TEXT), "pagenum".asRequired()),
    GLOSSARY("glossary", "text".asRequired(Argument.Type.TEXT)),
    GLQ("glq", display = ","),
    GLQQ("glqq", display = "„"),
    GRAPHICSPATH("graphicspath", RequiredFolderArgument("foldername"), dependency = GRAPHICX),
    GRQ("grq", display = "‘"),
    GRQQ("grqq", display = "“"),
    GUILLEMOTLEFT("guillemotleft", dependency = FONTENC.with("T1"), display = "«"),
    GUILLEMOTRIGHT("guillemotright", dependency = FONTENC.with("T1"), display = "»"),
    HFILL("hfill"),
    HIDEROWCOLORS("hiderowcolors", dependency = XCOLOR),
    HREF("href", "url".asRequired(), "text".asRequired(), dependency = LatexPackage.HYPERREF),
    HRULE("hrule"),
    HRULEFILL("hrulefill"),
    HSPACE("hspace", "length".asRequired()),
    HSPACE_STAR("hspace*", "length".asRequired()),
    HSS("hss"),
    HUGE("huge"),
    CAPITAL_HUGE("Huge"),
    HYPERREF("hyperref", "options".asOptional(), "label".asRequired(Argument.Type.TEXT), dependency = LatexPackage.HYPERREF),
    HYPHENATION("hyphenation", "words".asRequired(Argument.Type.TEXT)),
    I("i", display = "i (dotless)"),
    IMPORT("import", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INCLUDE("include", RequiredFileArgument("sourcefile", false, false, "tex")),
    INCLUDEFROM("includefrom", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INPUT("input", RequiredFileArgument("sourcefile", true, false, "tex")),
    INPUTFROM("inputfrom", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INCLUDEGRAPHICS("includegraphics", "key-val-list".asOptional(), RequiredPicturePathArgument("imagefile", true, false, "pdf", "png", "jpg", "mps", "jpeg", "jbig2", "jb2", "PDF", "PNG", "JPG", "JPEG", "JBIG2", "JB2", "eps"), dependency = GRAPHICX),
    INCLUDEONLY("includeonly", RequiredFileArgument("sourcefile", false, true, "tex")),
    INDEXNAME("indexname", "name".asRequired()),
    INDEXSPACE("indexspace"),
    INDEX("intex", "entry".asRequired()),
    IT("it"),
    ITEM("item", "label".asOptional()),
    ITSHAPE("itshape"),
    LABEL("label", "key".asRequired()),
    LARGE("large"),
    CAPITAL_LARGE("Large"),
    SCREAMING_LARGE("LARGE"),
    LATEX("LaTeX", display = "LaTeX"),
    LATEXE("LaTeXe", display = "LaTeX2ε"),
    LBRACK("lbrack", display = "["),
    LPAREN("lparen", display = "(", dependency = MATHTOOLS),
    ELLIPSIS("ldots", display = "…"),
    LEFTEQN("lefteqn"),
    LET("let"),
    LFSERIES("lfseries"),
    LINEBREAK("linebreak", "number".asOptional()),
    LINETHICKNESS("linethickness", "dimension".asRequired()),
    LINEWIDTH("linewidth"),
    LISTFIGURENAME("listfigurename", "name".asRequired(Argument.Type.TEXT)),
    LISTFILES("listfiles"),
    LISTOFFIGURES("listoffigures"),
    LISTOFTABLES("listoftables"),
    LISTTABLENAME("listtablename", "name".asRequired(Argument.Type.TEXT)),
    LOADCLASS("LoadClass", "options".asOptional(), RequiredFileArgument("class", true, false, "cls")),
    LOADCLASSWITHOPTIONS("LoadClassWithOptions", RequiredFileArgument("class", true, false, "cls")),
    LOWERCASE("lowercase", "text".asRequired(Argument.Type.TEXT)),
    LQ("lq", display = "‘"),
    MARG("marg", "arg".asRequired()),
    MAKEGLOSSARY("makeglossary"),
    MAKEINDEX("makeindex"),
    MAKELABEL("makelabel"),
    MAKELABELS("makelabels", "number".asRequired()),
    MAKENOIDXGLOSSARIES("makenoidxglossaries", dependency = GLOSSARIES),
    MAKETITLE("maketitle"),
    MASKCOLORS("maskcolors", "num model".asOptional(), "color".asRequired(), dependency = XCOLOR),
    MBOX("mbox", "text".asRequired()),
    MDSERIES("mdseries"),
    MEDSKIP("medskip"),
    MULTICOLUMN("multicolumn", "cols".asRequired(), "pos".asRequired(), "text".asRequired(Argument.Type.TEXT)),
    NAMEREF("nameref", "label".asRequired(Argument.Type.LABEL), dependency = LatexPackage.HYPERREF),
    NEWLABEL("newlabel"),
    NEWLENGTH("newlength", "length".asRequired()),
    NEWLINE("newline"),
    NEWPAGE("newpage"),
    NEWTHEOREM("newtheorem", "envname".asRequired(), "numberedlike".asOptional(), "caption".asRequired(Argument.Type.TEXT), "within".asOptional()),
    NEWTHEOREM_STAR("newtheorem*", "envname".asRequired(), "caption".asRequired(Argument.Type.TEXT)),
    NOCITE("nocite", "keys".asRequired()),
    NOFILES("nofiles"),
    NOLINEBREAK("nolinebreak", "number".asOptional()),
    NONUMBER("nonumber"),
    NOPAGEBREAK("nopagebreak", "number".asOptional()),
    NOPAGECOLOR("nopagecolor", dependency = COLOR),
    NORMALCOLOR("normalcolor", dependency = COLOR),
    NORMALFONT("normalfont"),
    NORMALSIZE("normalsize"),
    OARG("oarg", "arg".asRequired()),
    OE("oe", display = "œ"),
    OLDSTYLEENUMS("oldstylenums", "number".asRequired()),
    ONLYIFSTANDALONE("onlyifstandalone", "code".asRequired()), // dependency = standalone, but either class or package
    CAPITAL_OE("OE", display = "Œ"),
    ODDSIDEMARGIN("oddsidemargin"),
    ONECOLUMN("onecolumn"),
    PAGEBREAK("pagebreak", "number".asOptional()),
    PAGECOLOR("pagecolor", "color".asRequired(), dependency = COLOR),
    PAGECOLOR2("pagecolor", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    PAGENAME("pagename"),
    PAGENUMBERING("pagenumbering", "numstyle".asRequired()),
    PAGEREF("pageref", "label".asRequired(Argument.Type.LABEL)),
    PAGESTYLE("pagestyle", "style".asRequired()),
    PAGETOTAL("pagetotal"),
    PAPERWIDTH("paperwidth"),
    PAPERHEIGHT("paperheight"),
    PARAGRAPH("paragraph", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    PARAGRAPH_STAR("paragraph*", "title".asRequired(Argument.Type.TEXT)),
    PARAGRAPHMARK("paragraphmark"),
    PARBOX("parbox", "pos".asOptional(), "width".asRequired(), "text".asRequired(Argument.Type.TEXT)),
    PARINDENT("parindent"),
    PARG("parg", "arg".asRequired()),
    PARSKIP("parskip"),
    PART("part", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    PART_STAR("part*", "title".asRequired(Argument.Type.TEXT)),
    PARTNAME("partname", "name".asRequired(Argument.Type.TEXT)),
    PDFINFO("pdfinfo", "info".asRequired(Argument.Type.TEXT)),
    POUNDS("pounds", display = "£"),
    PRINTBIBLIOGRAPHY("printbibliography", dependency = BIBLATEX),
    PRINTINDEX("printindex"),
    PRINTNOIDXGLOSSARIES("printnoidxglossaries", dependency = GLOSSARIES),
    PROVIDESCLASS("ProvidesClass"),
    PROVIDESPACKAGE("ProvidesPackage"),
    R("r", display = "˚ (accent)"),
    RBRACK("rbrack", display = "]"),
    RPAREN("rparen", display = ")", dependency = MATHTOOLS),
    REF("ref", "label".asRequired(Argument.Type.LABEL)),
    REFNAME("refname", "name".asRequired(Argument.Type.TEXT)),
    REQUIREPACKAGE("RequirePackage", "options".asOptional(), RequiredFileArgument("package", true, true, "sty")),
    RESETCOLORSERIES("resetcolorseries", "div".asOptional(), "name".asRequired(), dependency = XCOLOR),
    RIGHTHYPHENMIN("righthyphenmin"),
    RIGHTMARGIN("rightmargin"),
    RIGHTMARK("rightmark"),
    RM("rm"),
    RMFAMILY("rmfamily"),
    ROMAN("roman", "counter".asRequired()),
    ROTATEBOX("rotatebox", "key-val-list".asOptional(), "degrees".asRequired(), "text".asRequired(Argument.Type.TEXT), dependency = GRAPHICX),
    ROWCOLORS("rowcolors", "commands".asOptional(), "row".asRequired(), "odd-row color".asRequired(), "even-row color".asRequired(), dependency = XCOLOR),
    ROWCOLORS_STAR("rowcolors*", "commands".asOptional(), "row".asRequired(), "odd-row color".asRequired(), "even-row color".asRequired(), dependency = XCOLOR),
    ROWNUM("rownum", dependency = XCOLOR),
    CAPITAL_ROMAN("Roman", "counter".asRequired()),
    RULE("rule", "line".asOptional(), "width".asRequired(), "thickness".asRequired()),
    RQ("rq", display = "’"),
    SAMEPAGE("samepage"),
    SBOX("sbox", "cmd".asRequired(), "length".asRequired()),
    SC("sc"),
    SCRIPTSIZE("scriptsize"),
    SCSHAPE("scshape"),
    SECTION("section", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    SECTION_STAR("section*", "title".asRequired(Argument.Type.TEXT)),
    SECTION_SIGN("S", display = "§"),
    SELECTFONT("selectfont"),
    SETCOUNTER("setcounter", "countername".asRequired(), "value".asRequired()),
    SETLENGTH("setlength", "cmd".asRequired(), "length".asRequired()),
    SFFAMILY("sffamily"),
    SHORTSTACK("shortstack", "pos".asOptional(), "text".asRequired(Argument.Type.TEXT)),
    SHOWROWCOLORS("showrowcolors", dependency = XCOLOR),
    SF("sf"),
    SL("sl"),
    SLSHAPE("slshape"),
    SMALL("small"),
    SMALLSKIP("smallskip"),
    SMASH("smash"),
    SOUT("sout", "strikethroughtext".asRequired(Argument.Type.TEXT), dependency = ULEM),
    SPACE("space"),
    STEPCOUNTER("stepcounter", "counter".asRequired()),
    STOP("stop"),
    STRETCH("stretch", "factor".asRequired()),
    SUBFILE("subfile", RequiredFileArgument("sourcefile", true, false, "tex"), dependency = LatexPackage.SUBFILES),
    SUBFILEINCLUDE("subfileinclude", RequiredFileArgument("sourcefile", true, false, "tex"), dependency = LatexPackage.SUBFILES),
    SUBIMPORT("subimport", RequiredFolderArgument("relative path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    SUBINCLUDEFROM("subincludefrom", RequiredFolderArgument("relative path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    SUBINPUTFROM("subinputfrom"),
    SUBITEM("subitem"),
    SUBPARAGRAPH("subparagraph", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    SUBPARAGRAPH_STAR("subparagraph*", "title".asRequired(Argument.Type.TEXT)),
    SUBPARAGRAPHMARK("subparagraphmark", "code".asRequired()),
    SUBSECTION("subsection", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    SUBSECTION_STAR("subsection*", "title".asRequired(Argument.Type.TEXT)),
    SUBSECTIONMARK("subsectionmark", "code".asRequired()),
    SUBSUBITEM("subsubitem"),
    SUBSUBSECTION("subsubsection", "shorttitle".asOptional(Argument.Type.TEXT), "title".asRequired(Argument.Type.TEXT)),
    SUBSUBSECTION_STAR("subsubsection*", "title".asRequired(Argument.Type.TEXT)),
    SUBSUBSECTIONMARK("subsubsectionmark", "code".asRequired()),
    SUPPRESSFLOATS("suppressfloats", "placement".asOptional()),
    SYMBOL("symbol", "n".asRequired()),
    TABCOLSEP("tabcolsep"),
    TABLENAME("tablename", "name".asRequired(Argument.Type.TEXT)),
    TABLEOFCONTENTS("tableofcontents"),
    TESTCOLOR("testcolor", "color".asRequired(), dependency = XCOLOR),
    TESTCOLOR2("testcolor", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    TEXT_ASCII_CIRCUMFLEX("textasciicircum", display = "^"),
    TEXT_ASCII_TILDE("textasciitilde", display = "~"),
    TEXT_CENTERED_ASTERISK("textasteriskcentered", display = "⁎"),
    TEXT_BACKSLASH("textbackslash", display = "\\"),
    TEXT_BAR("textbar", display = "|"),
    TEXTBF("textbf", "text".asRequired(Argument.Type.TEXT)),
    TEXTBRACELEFT("textbraceleft", display = "{"),
    TEXTBRACERIGHT("textbraceright", display = "}"),
    TEXT_BULLET("textbullet", display = "•"),
    CIRCLED_TEXT("textcircled", "a".asRequired()),
    TEXTCOLOR("textcolor", "color".asRequired(), "text".asRequired(), dependency = COLOR),
    TEXTCOLOR2("textcolor", "model-list".asOptional(), "spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    TEXT_COPYRIGHT("textcopyright", display = "©"),
    TEXTDAGGER("textdagger", display = "†"),
    TEXTDAGGERDBL("textdaggerdbl", display = "‡"),
    TEXT_DOLLAR("textdollar", display = "$"),
    TEXT_DOWN_ARROW("textdownarrow", dependency = TEXTCOMP, display = "↓"),
    TEXTELLIPSIS("textellipsis", display = "…"),
    TEXT_EM_DASH("textemdash", display = "—"),
    TEXT_EN_DASH("textendash", display = "–"),
    TEXT_UPSIDE_DOWN_EXCLAMATION("textexclamdown", display = "¡"),
    TEXT_GREATER_THAN("textgreater", display = ">"),
    TEXTHEIGHT("textheight"),
    TEXTIT("textit", "text".asRequired(Argument.Type.TEXT)),
    TEXT_LEFT_ARROW("textleftarrow", dependency = TEXTCOMP, display = "←"),
    TEXT_LESS_THAN("textless", display = "<"),
    TEXTLF("textlf", "text".asRequired(Argument.Type.TEXT)),
    TEXTMD("textmd", "text".asRequired(Argument.Type.TEXT)),
    TEXTNORMAL("textnormal"),
    TEXTPARAGRAPH("textparagraph"),
    TEXT_CENTERED_PERIOD("textperiodcentered", display = "·"),
    TEXT_UPSIDE_DOWN_QUESTION_MARK("textquestiondown", display = "¿"),
    TEXT_LEFT_DOUBLE_QUOTE("textquotedblleft", display = "“"),
    TEXT_RIGHT_DOUBLE_QUOTE("textquotedblright", display = "”"),
    TEXT_LEFT_QUOTE("textquoteleft", display = "‘"),
    TEXT_RIGHT_QUOTE("textquoteright", display = "’"),
    TEXT_REGISTERED("textregistered", display = "®"),
    TEXT_RIGHT_ARROW("textrightarrow", dependency = TEXTCOMP, display = "→"),
    TEXTRM("textrm", "text".asRequired(Argument.Type.TEXT)),
    TEXTSC("textsc", "textsc".asRequired(Argument.Type.TEXT)),
    TEXTSECTION("textsection", display = "§"),
    TEXTSF("textsf", "text".asRequired(Argument.Type.TEXT)),
    TEXTSL("textsl", "text".asRequired(Argument.Type.TEXT)),
    TEXTSTERLING("textsterling", display = "£"),
    TEXTSUBSCRIPT("textsubscript", "text".asRequired(Argument.Type.TEXT)),
    TEXTSUPERSCRIPT("textsuperscript", "text".asRequired(Argument.Type.TEXT)),
    TEXT_TRADEMARK("texttrademark", display = "™"),
    TEXTTT("texttt", "text".asRequired(Argument.Type.TEXT)),
    TEXTUNDERSCORE("textunderscore", display = "_"),
    TEXTUP("textup", "text".asRequired(Argument.Type.TEXT)),
    TEXT_UP_ARROW("textuparrow", dependency = TEXTCOMP, display = "↑"),
    TEXT_VISIBLE_SPACE("textvisiblespace", display = "␣"),
    TEXTWIDTH("textwidth"),
    THANKS("thanks", "to".asRequired(Argument.Type.TEXT)),
    THICKLINES("thicklines"),
    THINLINES("thinlines"),
    THISPAGESTYLE("thispagestyle", "style".asRequired()),
    THREF("thref", "label".asRequired(), dependency = NTHEOREM),
    TIME("time"),
    TINY("tiny"),
    TITLE("title", "text".asRequired(Argument.Type.TEXT)),
    TODAY("today"),
    TOPMARGIN("topmargin"),
    TT("tt"),
    TTFAMILY("ttfamily"),
    TWOCOLUMN("twocolumn", "text".asOptional(Argument.Type.TEXT)),
    UNBOLDMATH("unboldmath"),
    UNDERLINE("underline", "text".asRequired(Argument.Type.TEXT)),
    UNITLENGTH("unitlength"),
    UPPERCASE("uppercase", "text".asRequired(Argument.Type.TEXT)),
    UPSHAPE("upshape"),
    URL("url", "url".asRequired(), dependency = LatexPackage.HYPERREF),
    USEPACKAGE("usepackage", "options".asOptional(), RequiredFileArgument("package", true, true, "sty")),
    USEPGFPLOTSLIBRARY("usepgfplotslibrary", "libraries".asRequired()),
    USETIKZLIBRARY("usetikzlibrary", "libraries".asRequired()),
    VDOTS("vdots", display = "⋮"),
    VLINE("vline"),
    VREF("vref", "key".asRequired(Argument.Type.LABEL), dependency = VARIOREF),
    VREFRANGE("vrefrange", "start".asRequired(), "end".asRequired(), "text".asOptional(), dependency = VARIOREF),
    VSPACE("vspace", "length".asRequired()),
    VSPACE_STAR("vspace*", "length".asRequired()),
    WIDTH("width"),
    XGLOBAL("xglobal", dependency = XCOLOR),

    // Cleveref
    CREF("cref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CREF_CAPITAL("Cref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CREFRANGE("crefrange", "label1".asRequired(Argument.Type.LABEL), "label2".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CPAGEREF("cpageref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CPAGEREF_CAPITAL("Cpageref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CPAGEREFRANGE("cpagerefrange", "label1".asRequired(Argument.Type.LABEL), "label2".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    CPAGEREFRANGE_CAPITAL("Cpagerefrange", "label1".asRequired(Argument.Type.LABEL), "label2".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    NAMECREF("namecref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    NAMECREF_CAPITAL("nameCref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    LCNAMECREF("lcnamecref", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    NAMECREFS("namecrefs", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    NAMECREFS_CAPITAL("nameCrefs", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    LCNAMECREFS("lcnamecrefs", "label".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    LABELCREF("labelcref", "key".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    LABELCPAGEREF("labelcpageref", "key".asRequired(Argument.Type.LABEL), dependency = CLEVEREF),
    ;

    override val identifier: String
        get() = name
}