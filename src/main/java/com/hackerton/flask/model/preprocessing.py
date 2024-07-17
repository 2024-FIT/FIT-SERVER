import requests
import pandas as pd

# API 요청
url = "YOUR_API_ENDPOINT"
response = requests.get(url)
data = response.json()

# 필요한 데이터 추출
items = data['Items']

# DataFrame 생성
df = pd.DataFrame(items)

# CSV 파일로 저장
df.to_csv('food_data.csv', index=False)
