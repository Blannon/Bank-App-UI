package com.example.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.Card
import com.example.bankapp.ui.theme.BlueEnd
import com.example.bankapp.ui.theme.BlueStart
import com.example.bankapp.ui.theme.GreenEnd
import com.example.bankapp.ui.theme.GreenStart
import com.example.bankapp.ui.theme.OrangeEnd
import com.example.bankapp.ui.theme.OrangeStart
import com.example.bankapp.ui.theme.PurpLeEnd
import com.example.bankapp.ui.theme.PurpleStart

val cards = listOf(
  Card(
   cardType = "VISA",
   cardNumber = "3664 7865 3786 3976",
   cardName = "Business",
   balance = 899.99,
   color = getGradient(PurpleStart, PurpLeEnd),
  ),
  Card(
   cardType = "MasterCard",
   cardNumber = "234 7865 3786 3976",
   cardName = "Savings",
   balance = 699.99,
   color = getGradient(BlueStart, BlueEnd),
  ),
  Card(
   cardType = "VISA",
   cardNumber = "0078 7865 3786 3976",
   cardName = "School",
   balance = 299.99,
   color = getGradient(OrangeStart, OrangeEnd),
  ),
  Card(
   cardType = "MasterCard",
   cardNumber = "3564 7865 3786 3976",
   cardName = "Vacation",
   balance = 599.99,
   color = getGradient(GreenStart, GreenEnd)
  ),
 )

fun getGradient(
 startColor: Color,
 endColor: Color,
) : Brush {
 return Brush.horizontalGradient(
  colors = listOf(startColor, endColor)
 )
}
@Preview
@Composable
fun CardsSection(){
    LazyRow{
        items(cards.size){index ->
            CardItem(index, )
        }
    }
}

@Composable
fun CardItem(
    index: Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }
    
    var image = painterResource(id = R.drawable.visa)
    if (card.cardType == "MasterCard"){
        image = painterResource(
            id = R.drawable.mastercard )
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription =card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )

           Text(
               text = card.cardName,
               color = Color.White,
               fontSize = 17.sp,
               fontWeight = FontWeight.Bold
           )

            Text(
               text = "$ ${ card.balance }",
               color = Color.White,
               fontSize = 20.sp,
               fontWeight = FontWeight.Bold
           )
            Text(
               text = card.cardNumber,
               color = Color.White,
               fontSize = 19.sp,
               fontWeight = FontWeight.Bold
           )
        }
    }
}