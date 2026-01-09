from .base_page import BasePage
from selenium.webdriver.common.by import By

class ProductPage(BasePage):
    def add_to_basket(self):
        add_button = self.browser.find_element(By.CSS_SELECTOR, ".btn-add-to-basket")
        add_button.click()
        self.solve_quiz_and_get_code()
    
    def should_be_product_name_in_message(self):
        product_name = self.browser.find_element(By.CSS_SELECTOR, ".product_main h1").text
        message_product_name = self.browser.find_element(By.CSS_SELECTOR, ".alert-success strong").text
        assert product_name == message_product_name, "Product name doesn't match in success message"
    
    def should_be_basket_total_message(self):
        product_price = self.browser.find_element(By.CSS_SELECTOR, ".product_main .price_color").text
        basket_total = self.browser.find_element(By.CSS_SELECTOR, ".alert-info strong").text
        assert product_price == basket_total, "Basket total doesn't match product price"
