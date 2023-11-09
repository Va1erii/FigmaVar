# FigmaVar

Simple app for generating Xml, Swift output for colors

## Usage

1. Import your collection
   using [Figma Plugin](https://www.figma.com/community/plugin/1256972111705530093/export-import-variables)
2. Pass your collections into `OutputCollectionFactory`
3. Generate output. See `Main.kt` sample
4. Feel free to Fork and customize

### Example output

Android Xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="blue100">#FFDDEBFE</color>
    <color name="blue200">#FFC2DDFE</color>
    <color name="blue300">#FF99C8FD</color>
    <color name="blue400">#FF60A5FA</color>
    <color name="blue50">#FFF0F7FF</color>
    <color name="blue500">#FF4588F7</color>
    <color name="blue600">#FF2E69E8</color>
    <color name="blue700">#FF2857DA</color>
    <color name="blue800">#FF294AB3</color>
    <color name="blue900">#FF294490</color>
    <color name="bluegray100">#FFE4E6EA</color>
    <color name="bluegray200">#FFCED3D9</color>
    <color name="bluegray300">#FFB7BDC4</color>
    <color name="bluegray400">#FF9CA3AB</color>
    <color name="bluegray50">#FFF5F6F8</color>
    <color name="bluegray500">#FF747D87</color>
    <color name="bluegray600">#FF4E555E</color>
    <color name="bluegray700">#FF2F3742</color>
    <color name="bluegray800">#FF242A32</color>
    <color name="bluegray900">#FF191E25</color>
    <color name="cyan100">#FFCFFAFE</color>
    <color name="cyan200">#FFA5F3FC</color>
    <color name="cyan300">#FF67E8F9</color>
    <color name="cyan400">#FF22D3EE</color>
    <color name="cyan50">#FFECFEFF</color>
    <color name="cyan500">#FF06B6D4</color>
    <color name="cyan600">#FF0891B2</color>
    <color name="cyan700">#FF0E7490</color>
    <color name="cyan800">#FF155E75</color>
    <color name="cyan900">#FF164E63</color>
    <color name="gray100">#FFE9E9E9</color>
    <color name="gray200">#FFD2D2D2</color>
    <color name="gray300">#FFAFAFAF</color>
    <color name="gray400">#FF888888</color>
    <color name="gray50">#FFF5F5F5</color>
    <color name="gray500">#FF6E6E6E</color>
    <color name="gray600">#FF555555</color>
    <color name="gray700">#FF3D3D3D</color>
    <color name="gray800">#FF272727</color>
    <color name="gray900">#FF121212</color>
    <color name="green100">#FFC9FFE5</color>
    <color name="green200">#FF99F7CC</color>
    <color name="green300">#FF5CF0AF</color>
    <color name="green400">#FF1ED796</color>
    <color name="green50">#FFE6FDF2</color>
    <color name="green500">#FF00BA7F</color>
    <color name="green600">#FF059669</color>
    <color name="green700">#FF047857</color>
    <color name="green800">#FF065F46</color>
    <color name="green900">#FF064E3B</color>
    <color name="orange100">#FFFFDCBD</color>
    <color name="orange200">#FFFFC491</color>
    <color name="orange300">#FFFFAF69</color>
    <color name="orange400">#FFFF9632</color>
    <color name="orange50">#FFFFF6EE</color>
    <color name="orange500">#FFFF8614</color>
    <color name="orange600">#FFF87800</color>
    <color name="orange700">#FFE8651B</color>
    <color name="orange800">#FFD34613</color>
    <color name="orange900">#FFB92C00</color>
    <color name="pink100">#FFFBC9E3</color>
    <color name="pink200">#FFF8AAD3</color>
    <color name="pink300">#FFF68DC4</color>
    <color name="pink400">#FFF472B6</color>
    <color name="pink50">#FFFDEBF4</color>
    <color name="pink500">#FFF147A0</color>
    <color name="pink600">#FFEE218D</color>
    <color name="pink700">#FFDB117B</color>
    <color name="pink800">#FFBF0F6B</color>
    <color name="pink900">#FFA60D5D</color>
    <color name="purple100">#FFF3E8FF</color>
    <color name="purple200">#FFE9D5FF</color>
    <color name="purple300">#FFD8B4FE</color>
    <color name="purple400">#FFC084FC</color>
    <color name="purple50">#FFFAF5FF</color>
    <color name="purple500">#FFA855F7</color>
    <color name="purple600">#FF9333EA</color>
    <color name="purple700">#FF7E22CE</color>
    <color name="purple800">#FF6B21A8</color>
    <color name="purple900">#FF581C87</color>
    <color name="red100">#FFFEE2E2</color>
    <color name="red200">#FFFECACA</color>
    <color name="red300">#FFFCA5A5</color>
    <color name="red400">#FFF87171</color>
    <color name="red50">#FFFEF2F2</color>
    <color name="red500">#FFF24444</color>
    <color name="red600">#FFDC2626</color>
    <color name="red700">#FFB91C1C</color>
    <color name="red800">#FF991B1B</color>
    <color name="red900">#FF7F1D1D</color>
    <color name="white">#FFFFFFFF</color>
    <color name="yellow100">#FFFEF9C3</color>
    <color name="yellow200">#FFFEF08A</color>
    <color name="yellow300">#FFFDE047</color>
    <color name="yellow400">#FFFDE047</color>
    <color name="yellow50">#FFFEFCE8</color>
    <color name="yellow500">#FFEAB308</color>
    <color name="yellow600">#FFCA8A04</color>
    <color name="yellow700">#FFA16207</color>
    <color name="yellow800">#FF854D0E</color>
    <color name="yellow900">#FF713F12</color>
</resources>
```

iOS Swift

```
Black = Color(red: 0.0, green: 0.0, blue: 0.0, opacity: 1.0)
Blue100 = Color(red: 0.8666666746139526, green: 0.9215686321258545, blue: 0.9960784316062927, opacity: 1.0)
Blue200 = Color(red: 0.7607843279838562, green: 0.8666666746139526, blue: 0.9960784316062927, opacity: 1.0)
Blue300 = Color(red: 0.6000000238418579, green: 0.7843137383460999, blue: 0.9921568632125854, opacity: 1.0)
Blue400 = Color(red: 0.3764705955982208, green: 0.6470588445663452, blue: 0.9803921580314636, opacity: 1.0)
Blue50 = Color(red: 0.9411764740943909, green: 0.9686274528503418, blue: 1.0, opacity: 1.0)
Blue500 = Color(red: 0.2705882489681244, green: 0.5333333611488342, blue: 0.9686274528503418, opacity: 1.0)
Blue600 = Color(red: 0.18039216101169586, green: 0.4117647111415863, blue: 0.9098039269447327, opacity: 1.0)
Blue700 = Color(red: 0.1568627506494522, green: 0.34117648005485535, blue: 0.8549019694328308, opacity: 1.0)
Blue800 = Color(red: 0.16078431904315948, green: 0.29019609093666077, blue: 0.7019608020782471, opacity: 1.0)
Blue900 = Color(red: 0.16078431904315948, green: 0.2666666805744171, blue: 0.5647059082984924, opacity: 1.0)
Bluegray100 = Color(red: 0.8941176533699036, green: 0.9019607901573181, blue: 0.9176470637321472, opacity: 1.0)
Bluegray200 = Color(red: 0.8078431487083435, green: 0.8274509906768799, blue: 0.8509804010391235, opacity: 1.0)
Bluegray300 = Color(red: 0.7176470756530762, green: 0.7411764860153198, blue: 0.7686274647712708, opacity: 1.0)
Bluegray400 = Color(red: 0.6117647290229797, green: 0.6392157077789307, blue: 0.6705882549285889, opacity: 1.0)
Bluegray50 = Color(red: 0.9607843160629272, green: 0.9647058844566345, blue: 0.9725490212440491, opacity: 1.0)
Bluegray500 = Color(red: 0.4542014002799988, green: 0.4916839301586151, blue: 0.5291666388511658, opacity: 1.0)
Bluegray600 = Color(red: 0.3055555522441864, green: 0.33174601197242737, blue: 0.36666667461395264, opacity: 1.0)
Bluegray700 = Color(red: 0.18406249582767487, green: 0.21464459598064423, blue: 0.25833332538604736, opacity: 1.0)
Bluegray800 = Color(red: 0.1427951455116272, green: 0.16463439166545868, blue: 0.19583334028720856, opacity: 1.0)
Bluegray900 = Color(red: 0.09803921729326248, green: 0.11764705926179886, blue: 0.14509804546833038, opacity: 1.0)
Cyan100 = Color(red: 0.8117647171020508, green: 0.9803921580314636, blue: 0.9960784316062927, opacity: 1.0)
Cyan200 = Color(red: 0.6470588445663452, green: 0.9529411792755127, blue: 0.9882352948188782, opacity: 1.0)
Cyan300 = Color(red: 0.40392157435417175, green: 0.9098039269447327, blue: 0.9764705896377563, opacity: 1.0)
Cyan400 = Color(red: 0.13333334028720856, green: 0.8274509906768799, blue: 0.9333333373069763, opacity: 1.0)
Cyan50 = Color(red: 0.9254902005195618, green: 0.9960784316062927, blue: 1.0, opacity: 1.0)
Cyan500 = Color(red: 0.0235294122248888, green: 0.7137255072593689, blue: 0.8313725590705872, opacity: 1.0)
Cyan600 = Color(red: 0.0313725508749485, green: 0.5686274766921997, blue: 0.6980392336845398, opacity: 1.0)
Cyan700 = Color(red: 0.054901961237192154, green: 0.45490196347236633, blue: 0.5647059082984924, opacity: 1.0)
Cyan800 = Color(red: 0.08235294371843338, green: 0.3686274588108063, blue: 0.4588235318660736, opacity: 1.0)
Cyan900 = Color(red: 0.08627451211214066, green: 0.30588236451148987, blue: 0.38823530077934265, opacity: 1.0)
Gray100 = Color(red: 0.9137254953384399, green: 0.9137254953384399, blue: 0.9137254953384399, opacity: 1.0)
Gray200 = Color(red: 0.8235294222831726, green: 0.8235294222831726, blue: 0.8235294222831726, opacity: 1.0)
Gray300 = Color(red: 0.686274528503418, green: 0.686274528503418, blue: 0.686274528503418, opacity: 1.0)
Gray400 = Color(red: 0.5333333611488342, green: 0.5333333611488342, blue: 0.5333333611488342, opacity: 1.0)
Gray50 = Color(red: 0.9607843160629272, green: 0.9607843160629272, blue: 0.9607843160629272, opacity: 1.0)
Gray500 = Color(red: 0.4313725531101227, green: 0.4313725531101227, blue: 0.4313725531101227, opacity: 1.0)
Gray600 = Color(red: 0.3333333432674408, green: 0.3333333432674408, blue: 0.3333333432674408, opacity: 1.0)
Gray700 = Color(red: 0.239215686917305, green: 0.239215686917305, blue: 0.239215686917305, opacity: 1.0)
Gray800 = Color(red: 0.15294118225574493, green: 0.15294118225574493, blue: 0.15294118225574493, opacity: 1.0)
Gray900 = Color(red: 0.07058823853731155, green: 0.07058823853731155, blue: 0.07058823853731155, opacity: 1.0)
Green100 = Color(red: 0.7882353067398071, green: 1.0, blue: 0.8980392217636108, opacity: 1.0)
Green200 = Color(red: 0.6000000238418579, green: 0.9686274528503418, blue: 0.800000011920929, opacity: 1.0)
Green300 = Color(red: 0.3607843220233917, green: 0.9411764740943909, blue: 0.686274528503418, opacity: 1.0)
Green400 = Color(red: 0.11764705926179886, green: 0.843137264251709, blue: 0.5882353186607361, opacity: 1.0)
Green50 = Color(red: 0.9019607901573181, green: 0.9921568632125854, blue: 0.9490196108818054, opacity: 1.0)
Green500 = Color(red: 0.0, green: 0.729411780834198, blue: 0.49803921580314636, opacity: 1.0)
Green600 = Color(red: 0.019607843831181526, green: 0.5882353186607361, blue: 0.4117647111415863, opacity: 1.0)
Green700 = Color(red: 0.01568627543747425, green: 0.47058823704719543, blue: 0.34117648005485535, opacity: 1.0)
Green800 = Color(red: 0.0235294122248888, green: 0.37254902720451355, blue: 0.27450981736183167, opacity: 1.0)
Green900 = Color(red: 0.0235294122248888, green: 0.30588236451148987, blue: 0.23137255012989044, opacity: 1.0)
Orange100 = Color(red: 1.0, green: 0.8627451062202454, blue: 0.7411764860153198, opacity: 1.0)
Orange200 = Color(red: 1.0, green: 0.7686274647712708, blue: 0.5686274766921997, opacity: 1.0)
Orange300 = Color(red: 1.0, green: 0.686274528503418, blue: 0.4117647111415863, opacity: 1.0)
Orange400 = Color(red: 1.0, green: 0.5882353186607361, blue: 0.19607843458652496, opacity: 1.0)
Orange50 = Color(red: 1.0, green: 0.9647058844566345, blue: 0.9333333373069763, opacity: 1.0)
Orange500 = Color(red: 1.0, green: 0.5254902243614197, blue: 0.0784313753247261, opacity: 1.0)
Orange600 = Color(red: 0.9725490212440491, green: 0.47058823704719543, blue: 0.0, opacity: 1.0)
Orange700 = Color(red: 0.9098039269447327, green: 0.3960784375667572, blue: 0.10588235408067703, opacity: 1.0)
Orange800 = Color(red: 0.8274509906768799, green: 0.27450981736183167, blue: 0.07450980693101883, opacity: 1.0)
Orange900 = Color(red: 0.7254902124404907, green: 0.1725490242242813, blue: 0.0, opacity: 1.0)
Pink100 = Color(red: 0.9843137264251709, green: 0.7882353067398071, blue: 0.8901960849761963, opacity: 1.0)
Pink200 = Color(red: 0.9725490212440491, green: 0.6666666865348816, blue: 0.8274509906768799, opacity: 1.0)
Pink300 = Color(red: 0.9647058844566345, green: 0.5529412031173706, blue: 0.7686274647712708, opacity: 1.0)
Pink400 = Color(red: 0.95686274766922, green: 0.4470588266849518, blue: 0.7137255072593689, opacity: 1.0)
Pink50 = Color(red: 0.9921568632125854, green: 0.9215686321258545, blue: 0.95686274766922, opacity: 1.0)
Pink500 = Color(red: 0.9450980424880981, green: 0.27843138575553894, blue: 0.6274510025978088, opacity: 1.0)
Pink600 = Color(red: 0.9333333373069763, green: 0.12941177189350128, blue: 0.5529412031173706, opacity: 1.0)
Pink700 = Color(red: 0.8588235378265381, green: 0.06666667014360428, blue: 0.48235294222831726, opacity: 1.0)
Pink800 = Color(red: 0.7490196228027344, green: 0.05882352963089943, blue: 0.41960784792900085, opacity: 1.0)
Pink900 = Color(red: 0.6509804129600525, green: 0.05098039284348488, blue: 0.364705890417099, opacity: 1.0)
Purple100 = Color(red: 0.9529411792755127, green: 0.9098039269447327, blue: 1.0, opacity: 1.0)
Purple200 = Color(red: 0.9137254953384399, green: 0.8352941274642944, blue: 1.0, opacity: 1.0)
Purple300 = Color(red: 0.8470588326454163, green: 0.7058823704719543, blue: 0.9960784316062927, opacity: 1.0)
Purple400 = Color(red: 0.7529411911964417, green: 0.5176470875740051, blue: 0.9882352948188782, opacity: 1.0)
Purple50 = Color(red: 0.9803921580314636, green: 0.9607843160629272, blue: 1.0, opacity: 1.0)
Purple500 = Color(red: 0.658823549747467, green: 0.3333333432674408, blue: 0.9686274528503418, opacity: 1.0)
Purple600 = Color(red: 0.5764706134796143, green: 0.20000000298023224, blue: 0.9176470637321472, opacity: 1.0)
Purple700 = Color(red: 0.4941176474094391, green: 0.13333334028720856, blue: 0.8078431487083435, opacity: 1.0)
Purple800 = Color(red: 0.41960784792900085, green: 0.12941177189350128, blue: 0.658823549747467, opacity: 1.0)
Purple900 = Color(red: 0.3450980484485626, green: 0.10980392247438431, blue: 0.529411792755127, opacity: 1.0)
Red100 = Color(red: 0.9960784316062927, green: 0.886274516582489, blue: 0.886274516582489, opacity: 1.0)
Red200 = Color(red: 0.9960784316062927, green: 0.7921568751335144, blue: 0.7921568751335144, opacity: 1.0)
Red300 = Color(red: 0.9882352948188782, green: 0.6470588445663452, blue: 0.6470588445663452, opacity: 1.0)
Red400 = Color(red: 0.9725490212440491, green: 0.4431372582912445, blue: 0.4431372582912445, opacity: 1.0)
Red50 = Color(red: 0.9960784316062927, green: 0.9490196108818054, blue: 0.9490196108818054, opacity: 1.0)
Red500 = Color(red: 0.9490196108818054, green: 0.2666666805744171, blue: 0.2666666805744171, opacity: 1.0)
Red600 = Color(red: 0.8627451062202454, green: 0.14901961386203766, blue: 0.14901961386203766, opacity: 1.0)
Red700 = Color(red: 0.7254902124404907, green: 0.10980392247438431, blue: 0.10980392247438431, opacity: 1.0)
Red800 = Color(red: 0.6000000238418579, green: 0.10588235408067703, blue: 0.10588235408067703, opacity: 1.0)
Red900 = Color(red: 0.49803921580314636, green: 0.11372549086809158, blue: 0.11372549086809158, opacity: 1.0)
White = Color(red: 1.0, green: 1.0, blue: 1.0, opacity: 1.0)
Yellow100 = Color(red: 0.9960784316062927, green: 0.9764705896377563, blue: 0.7647058963775635, opacity: 1.0)
Yellow200 = Color(red: 0.9960784316062927, green: 0.9411764740943909, blue: 0.5411764979362488, opacity: 1.0)
Yellow300 = Color(red: 0.9921568632125854, green: 0.8784313797950745, blue: 0.27843138575553894, opacity: 1.0)
Yellow400 = Color(red: 0.9921568632125854, green: 0.8784313797950745, blue: 0.27843138575553894, opacity: 1.0)
Yellow50 = Color(red: 0.9960784316062927, green: 0.9882352948188782, blue: 0.9098039269447327, opacity: 1.0)
Yellow500 = Color(red: 0.9176470637321472, green: 0.7019608020782471, blue: 0.0313725508749485, opacity: 1.0)
Yellow600 = Color(red: 0.7921568751335144, green: 0.5411764979362488, blue: 0.01568627543747425, opacity: 1.0)
Yellow700 = Color(red: 0.6313725709915161, green: 0.3843137323856354, blue: 0.027450980618596077, opacity: 1.0)
Yellow800 = Color(red: 0.5215686559677124, green: 0.3019607961177826, blue: 0.054901961237192154, opacity: 1.0)
Yellow900 = Color(red: 0.4431372582912445, green: 0.24705882370471954, blue: 0.07058823853731155, opacity: 1.0)
```