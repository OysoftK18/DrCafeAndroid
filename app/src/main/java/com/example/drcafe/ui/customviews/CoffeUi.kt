package com.example.drcafe.ui.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drcafe.R

@Preview
@Composable
fun CustomRadioButton(selected: Boolean = false, description: String = "Ipso lorum") {
    Box(
        modifier = Modifier
            .border(
                1.dp,
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .padding(end = 8.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected,
                onClick = { /*TODO*/ },
                colors = RadioButtonDefaults.colors(unselectedColor = Color.White)
            )
            Text(text = description, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Preview
@Composable
fun CustomTextBox(
    descriptionQuestion: String = "ipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorumipso lorum",
    numberQuestion: Int = 0
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)){
            Box (modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.TopCenter){
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 20.sp)) {
                        append(stringResource(R.string.question_number))
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 26.sp)) {
                        append(stringResource(R.string.number_question, numberQuestion))
                    }
                })
            }
            Text(text = descriptionQuestion)
        }
    }
}

@Preview
@Composable
fun FullTrivia(answers: List<String> = listOf("","","")){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally) {
        CustomTextBox()
        answers.forEach{ _ ->
            CustomRadioButton()
        }
        Row(modifier = Modifier.padding(horizontal = 10.dp)) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1.0f)) {
                Text(text = stringResource(R.string.return_last_question))
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1.0f)) {
                Text(text = stringResource(R.string.next_question))
            }
        }
    }
}

@Preview
@Composable
fun SpotifyWireFrame(){
    var title: String = ""
    var description: String = ""
    Column {
        Image(painter = painterResource(id = androidx.core.R.id.accessibility_custom_action_14), contentDescription = "Spotify song image")
        Text(text = "Title: $title")
        Text(text = "Description: $description")
        Image(painter = painterResource(id = androidx.core.R.id.accessibility_custom_action_14), contentDescription = "QR code")
    }
}