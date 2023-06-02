"""
URL configuration for DJANGO_MEM project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.urls import path
from DJANGO_MEM import view

urlpatterns = [
    path('', view.mem_list),
    path('mem_list', view.mem_list),
    path('mem_add', view.mem_add),
    path('mem_detail', view.mem_detail),
    path('mem_mod', view.mem_mod),
    path('mem_mod_act', view.mem_mod_act),
    path('mem_add_act', view.mem_add_act),
    path('mem_del_act', view.mem_del_act),
]
