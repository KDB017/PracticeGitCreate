var choiceAnswer=document.getElementsByName("answer");

function checkAns()
{
    var placeAnswer=document.getElementById("praceans"); 
    let choiceAnswer=serchCheck();
    let answerText=trueAns(choiceAnswer);
    placeAnswer.innerHTML=answerText;
}

function serchCheck()
{
    let len=choiceAnswer.length;
    let choiceCheck="";
    for(let i=0;i<len;i++)
    {
        if(choiceAnswer.item(i).checked)
        [
            choiceCheck=choiceAnswer.item(i).value
        ]
    }
    return choiceCheck;
}
function trueAns(checkAns)
{
    let answerText="";
    if(checkAns=="true")
    {
        answerText="<p>正解です</p>";
    }
    else
    {
        answerText="<p>不正解です</p>";
    }
    return answerText;
}